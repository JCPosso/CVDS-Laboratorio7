/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.samples.services.client;



import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.TipoItem;

/**
 *
 * @author hcadavid
 */
public class MyBatisExample {

    /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException 
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();

        try(SqlSession sqlss = sessionfact.openSession()) {
            //Mappers
            ClienteMapper clienteMapper = sqlss.getMapper(ClienteMapper.class);
            ItemMapper itemMapper = sqlss.getMapper(ItemMapper.class);
            TipoItemMapper tipoItemMapper = sqlss.getMapper(TipoItemMapper.class);
            ItemRentadoMapper itemRentadoMapper = sqlss.getMapper(ItemRentadoMapper.class);
            //Pruebas Mapper Usuario OK
            //System.out.println(clienteMapper.consultarClientes()); 
            //System.out.println(clienteMapper.consultarCliente(98347)); //Bill Clinton

            //Pruebas Mapper Item OK
            //System.out.println(itemMapper.consultarItem(2));
            //System.out.println(itemMapper.consultarItems());

            // //Insertar tipo item  Ok
             //tipoItemMapper.addTipoItem("Jorgito Guayaco0o");
            //  TipoItem tipo = tipoItemMapper.getTipoItem(1);
            //  itemMapper.insertarItem(new Item(tipo, 2143370, "Jorgito", "Jorgito el guayaco", new Date(), 50000, "formatoRenta", "undefined"));
            //  clienteMapper.agregarItemRentadoACliente(98347, 2143369, new Date(), new Date());
            System.out.println(itemRentadoMapper.consultarItemRentado(99,2132674));
             sqlss.commit();

            sqlss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
