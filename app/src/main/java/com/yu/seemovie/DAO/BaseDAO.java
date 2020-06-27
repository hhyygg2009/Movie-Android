package com.yu.seemovie.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.yu.seemovie.R;

public class BaseDAO extends SQLiteOpenHelper {

    final static String DATABASENAME = "moive.db";
    private static final String TAG = "dbhelper";
//	public static SQLiteDatabase db;

    public BaseDAO(Context context) {
        super(context, DATABASENAME, null, 1);
        // TODO Auto-generated constructor stub

//         db = getReadableDatabase();
//        String sql2 = "select * from moive";
//        Cursor cursor=db.rawQuery(sql2,null);
//        int count=cursor.getCount();
//        Log.i("db", "onCreate: "+count);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//		String sql = "CREATE TABLE book " + "(" + "isbn  TEXT NOT NULL,"
//				+ "bookname  TEXT," + "publishertime  TEXT," + "issell  TEXT," + "picture  BLOB,"
//				+ "PRIMARY KEY (isbn)" + ");";
        String sql = "CREATE TABLE `moive` (  `Id` int(11) NOT NULL,  `title` varchar(255) DEFAULT NULL,  `score` varchar(255) DEFAULT NULL,  `title_sub` varchar(255) DEFAULT NULL,  `story` varchar(255) DEFAULT NULL,  `classid` varchar(255) DEFAULT NULL,  `releasetime` varchar(255) DEFAULT NULL,  `duration` varchar(255) DEFAULT NULL,  `regionid` varchar(255) DEFAULT NULL,  `langid` varchar(255) DEFAULT NULL,  `custompicpos` varchar(255) DEFAULT NULL)";


        String sql1 =
                "INSERT INTO `moive` (`Id`, `title`, `score`, `title_sub`, `story`, `classid`, `releasetime`, `duration`, `regionid`, `langid`, `custompicpos`) " +
                        "VALUES(1, '中国合伙人2', '6.5', '互联网创业启示录', '《中国合伙人2》是刘亚当执导的剧情片，赵立新、凌潇肃、王嘉、董琦等主演，于2018年12月18日在中国内地上映。影片以徐顺之的视角展现了一个程序员向创业者的蜕变，讲述了一代互联网人追逐梦想的传奇创业故事。2018年11月29日，由国家电影局指导，中影股份、华夏电影公司等单位联合推介，作为庆祝改革开放40周年9部重点国产影片之一。', NULL, '2018', '122', '', '', '" + R.drawable.cover__1_ + "')," +
                        "(2, '一出好戏', '7.6', '黄渤艺兴荒岛求生', '暑假，十二岁的双胞胎凯文凯武央求母亲给他们买新自行车。他们骑着新自行车带着同村小孩兴奋地在路...', NULL, NULL, NULL, NULL, NULL, " + R.drawable.cover__2_ + ")," +
                        "(3, '一句顶一万句', '7.0', '范伟刘蓓中年结婚', '美丽的云顶村，热情为民的年轻村长方春天，在筹备莅临本村的一场国际山地马拉松分站赛过程中，遇到...', NULL, NULL, NULL, NULL, NULL, " + R.drawable.cover__3_ + ")," +
                        "(4, '华丽上班族', '6.8', '全明星阵容歌舞片', NULL, NULL, NULL, NULL, NULL, NULL, " + R.drawable.cover__4_ + ")," +
                        "(5, '巴黎假期', '6.0', '古仔采洁巴黎相爱', NULL, NULL, NULL, NULL, NULL, NULL, " + R.drawable.cover__5_ + ");";


//		String sql2 = "select * from moive";
//		String sql2 = "INSERT INTO moive VALUES ('9787111187776', '算法导论1', '2005-07-05', '否', NULL);";
//		String sql3 = "INSERT INTO moive VALUES ('9787111187703', '算法导论2', '2005-07-05', '否', NULL);";
//		String sql4 = "INSERT INTO moive VALUES ('9787111187704', '算法导论3', '2005-07-05', '否', NULL);";
//		String sql5 = "INSERT INTO moive VALUES ('9787111187705', '算法导论4', '2005-07-05', '否', NULL);";
//		String sql6 = "INSERT INTO moive VALUES ('9787111187706', '算法导论5', '2005-07-05', '否', NULL);";
        db.execSQL(sql);
        db.execSQL(sql1);


//		Cursor cursor=db.rawQuery(sql2,null);
//		int count=cursor.getCount();
//		Log.i(TAG, "onCreate: "+count);

//		db.execSQL(sql2);
//		db.execSQL(sql3);
//		db.execSQL(sql4);
//		db.execSQL(sql5);
//		db.execSQL(sql6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}
