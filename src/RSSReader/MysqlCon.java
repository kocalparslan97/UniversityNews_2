package RSSReader;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.PreparedStatement;

public class MysqlCon {
	

	RssXmlReader rss = new RssXmlReader();

	public static void BBCNewInsertFunc(String haber_ids, String hash, String titles, String descs, String links,
			String kurum_lists, String yayin_yeri, String yayin_tarihi, String eklenme_tarihi) {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/unihaber_db?useUnicode=true&characterEncoding=utf-8", "root", "");

			String sql = "INSERT INTO `bbchaber`(`haber_id`, `hash`,  `baslik`, "
					+ "`ozet`,  `link`, `kurum_list`,  `yayin_yeri`,   `yayin_tarihi`, `eklenme_tarihi`)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			preparedStatement.setString(1, haber_ids);
			preparedStatement.setString(2, hash);
			preparedStatement.setString(3, titles);
			preparedStatement.setString(4, descs);
			preparedStatement.setString(5, links);
			preparedStatement.setString(6, kurum_lists);
			preparedStatement.setString(7, yayin_yeri);
			preparedStatement.setString(8, yayin_tarihi);
			preparedStatement.setString(9, eklenme_tarihi);

			preparedStatement.execute();
			System.out.println("haber bilgileri eklendi");

			preparedStatement.close();
			con.close();
		} catch (Exception e) {
			System.out.println("hata=" + e);
		}
	}

	public static void CnnTurkNewInsertFunc(String haber_ids, String hash, String titles, String descs, String links,
			String kurum_lists, String yayin_yeri, String yayin_tarihi, String eklenme_tarihi) {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/unihaber_db?useUnicode=true&characterEncoding=utf-8", "root", "");

			String sql = "INSERT INTO `cnnturk`(`haber_id`, `hash`,  `baslik`, "
					+ "`ozet`,  `link`, `kurum_list`,  `yayin_yeri`,   `yayin_tarihi`, `eklenme_tarihi`)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			preparedStatement.setString(1, haber_ids);
			preparedStatement.setString(2, hash);
			preparedStatement.setString(3, titles);
			preparedStatement.setString(4, descs);
			preparedStatement.setString(5, links);
			preparedStatement.setString(6, kurum_lists);
			preparedStatement.setString(7, yayin_yeri);
			preparedStatement.setString(8, yayin_tarihi);
			preparedStatement.setString(9, eklenme_tarihi);

			preparedStatement.execute();
			System.out.println("haber bilgileri eklendi");

			preparedStatement.close();
			con.close();
		} catch (Exception e) {
			System.out.println("hata=" + e);
		}
	}

	public static void CumhuriyetNewInsertFunc(String haber_ids, String hash, String titles, String descs, String links,
			String kurum_lists, String yayin_yeri, String yayin_tarihi, String eklenme_tarihi) {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/unihaber_db?useUnicode=true&characterEncoding=utf-8", "root", "");

			String sql = "INSERT INTO `cumhuriyethaber`(`haber_id`, `hash`,  `baslik`, "
					+ "`ozet`,  `link`, `kurum_list`,  `yayin_yeri`,   `yayin_tarihi`, `eklenme_tarihi`)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			preparedStatement.setString(1, haber_ids);
			preparedStatement.setString(2, hash);
			preparedStatement.setString(3, titles);
			preparedStatement.setString(4, descs);
			preparedStatement.setString(5, links);
			preparedStatement.setString(6, kurum_lists);
			preparedStatement.setString(7, yayin_yeri);
			preparedStatement.setString(8, yayin_tarihi);
			preparedStatement.setString(9, eklenme_tarihi);

			preparedStatement.execute();
			System.out.println("haber bilgileri eklendi");

			preparedStatement.close();
			con.close();
		} catch (Exception e) {
			System.out.println("hata=" + e);
		}
	}

	public static void HurriyetNewInsertFunc(String haber_ids, String hash, String titles, String descs, String links,
			String kurum_lists, String yayin_yeri, String yayin_tarihi, String eklenme_tarihi) {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/unihaber_db?useUnicode=true&characterEncoding=utf-8", "root", "");

			String sql = "INSERT INTO `hurriyethaber`(`haber_id`, `hash`,  `baslik`, "
					+ "`ozet`,  `link`, `kurum_list`,  `yayin_yeri`,   `yayin_tarihi`, `eklenme_tarihi`)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			preparedStatement.setString(1, haber_ids);
			preparedStatement.setString(2, hash);
			preparedStatement.setString(3, titles);
			preparedStatement.setString(4, descs);
			preparedStatement.setString(5, links);
			preparedStatement.setString(6, kurum_lists);
			preparedStatement.setString(7, yayin_yeri);
			preparedStatement.setString(8, yayin_tarihi);
			preparedStatement.setString(9, eklenme_tarihi);

			preparedStatement.execute();
			System.out.println("haber bilgileri eklendi");

			preparedStatement.close();
			con.close();
		} catch (Exception e) {
			System.out.println("hata=" + e);
		}
	}

	public static void UlusalKanalNewInsertFunc(String haber_ids, String hash, String titles, String descs,
			String links, String kurum_lists, String yayin_yeri, String yayin_tarihi, String eklenme_tarihi) {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/unihaber_db?useUnicode=true&characterEncoding=utf-8", "root", "");

			String sql = "INSERT INTO `ulusalkanalhaber`(`haber_id`, `hash`,  `baslik`, "
					+ "`ozet`,  `link`, `kurum_list`,  `yayin_yeri`,   `yayin_tarihi`, `eklenme_tarihi`)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement(sql);

			preparedStatement.setString(1, haber_ids);
			preparedStatement.setString(2, hash);
			preparedStatement.setString(3, titles);
			preparedStatement.setString(4, descs);
			preparedStatement.setString(5, links);
			preparedStatement.setString(6, kurum_lists);
			preparedStatement.setString(7, yayin_yeri);
			preparedStatement.setString(8, yayin_tarihi);
			preparedStatement.setString(9, eklenme_tarihi);

			preparedStatement.execute();
			System.out.println("haber bilgileri eklendi");

			preparedStatement.close();
			con.close();
		} catch (Exception e) {
			System.out.println("hata=" + e);
		}
	}

	public static void main(String[] args) {

		// sqlbaslat();
	}

}
