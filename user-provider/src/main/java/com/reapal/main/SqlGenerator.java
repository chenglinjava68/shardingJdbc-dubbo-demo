package com.reapal.main;

/**
 * Created by jack-cooper on 2017/2/13.
 */
public class SqlGenerator {
    public static void main(String[] args) {
        String sql = "drop database if exists demodb;\n" +
                "CREATE database demodb DEFAULT CHARACTER SET utf8;";
        String tableSql = "CREATE TABLE demodb.user (\n" +
                "  id bigint(64) NOT NULL,\n" +
                "  name varchar(100) DEFAULT NULL,\n" +
                "  age int(11) DEFAULT NULL,\n" +
                "  PRIMARY KEY (id),\n" +
                "  UNIQUE KEY id_UNIQUE (id)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        generateDDLSql(sql,tableSql,4,8,"demodb","user");
    }

    public static void generateDDLSql(String sql,String tableSql,int dbNum,int tableNum,String dbKeyWord,String tableKyeWord){
        for(int i = 0 ; i < dbNum ; i++) { //数据库
            String tempSql = sql.replaceAll(dbKeyWord,dbKeyWord + (i<10?"0"+i:i));
            System.out.println("-- ====================database"+i+"====================== --");
            System.out.println(tempSql);
            for(int j = 0 ; j < tableNum ; j++){
                String tempTabelSql = tableSql
                        .replaceAll(dbKeyWord,dbKeyWord + (i<10?"0"+i:i))
                        .replaceAll(tableKyeWord,tableKyeWord+"_"+j);
                System.out.println(tempTabelSql);
            }
            System.out.println("\n\n\n");
        }
    }
}
