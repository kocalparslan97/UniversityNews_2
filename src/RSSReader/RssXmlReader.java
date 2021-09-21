package RSSReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

//import com.mysql.jdbc.StringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.syndication.io.FeedException;

public class RssXmlReader {
	public static ArrayList<String> all_uni = new ArrayList<String>();
	public static ArrayList<String> kurum_list = new ArrayList<String>();

	// Haber kanallarinin Hash Map degerleri
	public static HashMap<String, List<String>> cnnturkMap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> bbcturkMap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> birgunMap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> cumhuriyetMap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> haberturkMap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> hurriyetmap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> intHaberMap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> milliyetMap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> ntvMap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> sabahMap = new HashMap<String, List<String>>();
	public static HashMap<String, List<String>> ulusalKanalMap = new HashMap<String, List<String>>();

	public static List<String> cnnturkList = new ArrayList<String>();
	public static List<String> bbcturkList = new ArrayList<String>();
	public static List<String> birgunList = new ArrayList<String>();
	public static List<String> cumhuriyetList = new ArrayList<String>();
	public static List<String> haberturkList = new ArrayList<String>();
	public static List<String> hurriyetList = new ArrayList<String>();
	public static List<String> intHaberList = new ArrayList<String>();
	public static List<String> milliyetList = new ArrayList<String>();
	public static List<String> ntvList = new ArrayList<String>();
	public static List<String> sabahList = new ArrayList<String>();
	public static List<String> ulusalKanalList = new ArrayList<String>();

	public static void main(String[] args)
			throws IllegalArgumentException, FeedException, IOException, ParserConfigurationException, SAXException {
		// showNewsInfo();
		// ReadExcelFile();
		// ReadInvoices();
		// RssXmlReader rsx = new RssXmlReader();
		// System.out.println("--Call Excel Content With Return Statement-- ");
		// System.out.println(rsx.getAllUni(all_uni));
		// System.out.println(getAllUni() + "\n\n");
		// atomReadUsingRome();

		String[] urls = { "https://feeds.bbci.co.uk/turkce/rss.xml", "https://www.cnnturk.com/feed/rss/turkiye/news",
				"https://www.cumhuriyet.com.tr/rss", "https://www.hurriyet.com.tr/rss/anasayfa",
				"http://www.ulusalkanal.com.tr/rss.php" };
		for (int h = 0; h < urls.length; h++) {
			String temp = urls[h];
			showNewsInfo(temp);
			System.out.println("h degeri :" + h);
		}

		// convertDateToString();
	}
	/*
	 * HashMap<String, String> denehash = new HashMap<String, String>();
	 * denehash.put("Türkiye", "Ankara"); denehash.put("Fransa", "Paris");
	 * denehash.put("İngiltere", "Londra");
	 * 
	 * Set s1 = denehash.entrySet(); Iterator i = s1.iterator();
	 * 
	 * System.out.println(denehash.get("Türkiye")); while (i.hasNext()) { Map.Entry
	 * item = (Map.Entry) i.next(); System.out.println(item.getKey() + " => " +
	 * item.getValue()); }
	 */

//		cnnturkList.add("alp");
//		cnnturkList.add("izmir");
//		cnnturkMap.put("cnnturk", cnnturkList);
//		cnnturkMap.put("cnnturk", cnnturkList);
//		Set s = cnnturkMap.entrySet();
//		Iterator i = s.iterator();
//		while (i.hasNext()) {
//			Map.Entry item = (Map.Entry) i.next();
//			System.out.println(item.getKey() + " -> " + item.getValue());
//		}
	// boolean dene = StringUtils.containsIgnoreCase("Fırat Üniversitesi", "fırat");
	// System.out.println(dene);

	// convertDateToString();
	// convertDateToStrng();

	public static void convertDateToString() {
		LocalDateTime myDateObj = LocalDateTime.of(2021, 8, 27, 16, 20);
//		System.out.println("before formatting  : " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);

		System.out.println("After Formatting :" + formattedDate);
	}

	public static void convertDateToStrng() throws ParseException {
		// Bu formattan "Thu, 26 Aug 2021 21:02:00 GMT"
		// Bu Formata "dd-MM-yyyy HH:mm:ss" düzenleme yap
		String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		int year;

		GregorianCalendar gcalendar = new GregorianCalendar();
		// Display current time and date information.
		System.out.print("Date: ");
		System.out.print(months[gcalendar.get(Calendar.MONTH)]);
		System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
		System.out.println(year = gcalendar.get(Calendar.YEAR));
		System.out.print("Time: ");
		System.out.print(gcalendar.get(Calendar.HOUR) + ":");
		System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
		System.out.println(gcalendar.get(Calendar.SECOND));
	}

	public static void atomReadUsingRome(String urlAddress)
			throws IOException, ParserConfigurationException, SAXException {
		// https://dzone.com/articles/reading-atom-fee
	}

	public static void showNewsInfo(String urlAddress) throws IOException, ParserConfigurationException, SAXException {
		/*
		 * 1)https://feeds.bbci.co.uk/turkce/rss.xml
		 * 2)https://www.birgun.net/xml/rss.xml
		 * 3)https://www.cnnturk.com/feed/rss/turkiye/news
		 * 4)https://www.cumhuriyet.com.tr/rss 5)https://www.haberturk.com/rss
		 * 6)https://www.hurriyet.com.tr/rss/anasayfa
		 * 7)https://www.internethaber.com/rss
		 * 8)https://www.milliyet.com.tr/rss/rssnew/dunyarss.xml
		 * 9)https://www.ntv.com.tr/turkiye.rss
		 * 10)https://www.sabah.com.tr/rss/anasayfa.xml
		 * 12)http://www.ulusalkanal.com.tr/rss.php
		 */
		// String uri = "https://feeds.bbci.co.uk/turkce/rss.xml";
		String uri = urlAddress;
		// URL url = new URL("https://feeds.bbci.co.uk/turkce/rss.xml");
		URL url = new URL(urlAddress);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", uri);

		InputStream xml = connection.getInputStream();

		// or if you prefer DOM:
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new URL(uri).openStream());

		doc.getDocumentElement().normalize();
		System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());

		NodeList nList = doc.getElementsByTagName("item");

		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);
			System.out.println("\nCurrent Element : " + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;

				Node node1 = elem.getElementsByTagName("guid").item(0);
				String fguid = node1.getTextContent();

				Node node2 = elem.getElementsByTagName("link").item(0);
				String fLink = node2.getTextContent();

				Node node3 = elem.getElementsByTagName("title").item(0);
				String fTitle = node3.getTextContent();

				Node node4 = elem.getElementsByTagName("description").item(0);
				String fDesc = node4.getTextContent();

				Node node5 = elem.getElementsByTagName("pubDate").item(0);
				String fpubDate = node5.getTextContent();

				RssNewsFeed rssnewsf = new RssNewsFeed();

				rssnewsf.setGuId(fguid);
				rssnewsf.setLink(fLink);
				rssnewsf.setTitle(fTitle);
				rssnewsf.setContent(fDesc);
				rssnewsf.setPubDate(fpubDate);

				System.out.println("Haber ID: " + rssnewsf.getGuId());
				System.out.println("Haber Link: " + rssnewsf.getLink());
				System.out.println("Haber Title: " + rssnewsf.getTitle());
				System.out.println("Haber Description: " + rssnewsf.getContent());
				System.out.println("Haber pubDate: " + rssnewsf.getPubDate());

				System.out.println("-----------------------------------");
				// Bu işlemleri tek bir java dosyasında ve get set metodları kullanarak yapmam
				// gerekiyor.
				// SearchUniFromNews(fLink, "Fırat");
				// SearchUniFromNews(fTitle, "Fırat");
				// SearchUniFromNews(fDesc, "Fırat");
				String str = StringUtils.substring(fDesc, 0);
				String str1 = StringUtils.substring(fTitle, 0);
				String link = StringUtils.substring(fLink, 0);
				String[] strPar = str.split(" ");
				String[] strPar1 = str.split(" ");

				all_uni = getAllUni();

				System.out.println("Desc : " + str);
				System.out.println("Title : " + str1);
				System.out.println("-----------------------------------");
				for (int u = 0; u < all_uni.size(); u++) {
					String temp = all_uni.get(u);
					boolean isTitleContain1 = StringUtils.containsIgnoreCase(rssnewsf.getTitle(), temp);
					boolean isDescContain1 = StringUtils.containsIgnoreCase(rssnewsf.getContent(), temp);
					if (isTitleContain1 == true || isDescContain1 == true) {
						if (uri.contains("https://feeds.bbci.co.uk/turkce/rss.xml")) {
							if (!bbcturkList.contains(temp)) {
								bbcturkList.add(temp);
								bbcturkMap.put("bccturk", bbcturkList);

								System.out.println("---SQL Insert---");

								MysqlCon.BBCNewInsertFunc(rssnewsf.getGuId(), "bbc", rssnewsf.getTitle(),
										rssnewsf.getContent(), rssnewsf.getLink(), temp, "BBC Haber",
										rssnewsf.getPubDate(), rssnewsf.getPubDate());
							}
						} else if (uri.contains("https://www.cnnturk.com/feed/rss/turkiye/news")) {
							if (!cnnturkList.contains(temp)) {
								cnnturkList.add(temp);
								cnnturkMap.put("cnnturk", cnnturkList);

								System.out.println("---SQL Insert---");

								MysqlCon.CnnTurkNewInsertFunc(rssnewsf.getGuId(), "cnnturk", rssnewsf.getTitle(),
										rssnewsf.getContent(), rssnewsf.getLink(), temp, "CnnTurk Haber",
										rssnewsf.getPubDate(), rssnewsf.getPubDate());
							}

						} else if (uri.contains("https://www.cumhuriyet.com.tr/rss")) {
							if (!cumhuriyetList.contains(temp)) {
								cumhuriyetList.add(temp);
								cumhuriyetMap.put("cumhuriyet", cumhuriyetList);

								System.out.println("---SQL Insert---");

								MysqlCon.CumhuriyetNewInsertFunc(rssnewsf.getGuId(), "cumhuriyet", rssnewsf.getTitle(),
										rssnewsf.getContent(), rssnewsf.getLink(), temp, "Cumhuriyet Haber",
										rssnewsf.getPubDate(), rssnewsf.getPubDate());
							}

						} else if (uri.contains("https://www.hurriyet.com.tr/rss/anasayfa")) {
							if (!hurriyetList.contains(temp)) {
								hurriyetList.add(temp);
								hurriyetmap.put("hurriyet", hurriyetList);

								System.out.println("---SQL Insert---");

								MysqlCon.HurriyetNewInsertFunc(rssnewsf.getGuId(), "hurriyet", rssnewsf.getTitle(),
										rssnewsf.getContent(), rssnewsf.getLink(), temp, "Hürriyet Haber",
										rssnewsf.getPubDate(), rssnewsf.getPubDate());
							}

						} else if (uri.contains("http://www.ulusalkanal.com.tr/rss.php")) {
							if (!ulusalKanalList.contains(temp)) {
								ulusalKanalList.add(temp);
								ulusalKanalMap.put("ulusalkanal", ulusalKanalList);

								System.out.println("---SQL Insert---");

								MysqlCon.UlusalKanalNewInsertFunc(rssnewsf.getGuId(), "ulusalkanal",
										rssnewsf.getTitle(), rssnewsf.getContent(), rssnewsf.getLink(), temp,
										"Ulusal Kanal Haber", rssnewsf.getPubDate(), rssnewsf.getPubDate());
							}

						}
					} else {
						// System.out.println("Eşleşmedi..");
					}
				}
			}
		}

//				}
		System.out.println("-----------------------------------");
		System.out.println("--Haberdeki Üniversite(ler)--");
		Set s1 = bbcturkMap.entrySet();
		Iterator i1 = s1.iterator();
		while (i1.hasNext()) {
			Map.Entry item = (Map.Entry) i1.next();
			System.out.println(item.getKey() + " -> " + item.getValue());
		}
		Set s2 = cnnturkMap.entrySet();
		Iterator i2 = s2.iterator();
		while (i2.hasNext()) {
			Map.Entry item = (Map.Entry) i2.next();
			System.out.println(item.getKey() + " -> " + item.getValue());
		}
		Set s3 = cumhuriyetMap.entrySet();
		Iterator i3 = s3.iterator();
		while (i3.hasNext()) {
			Map.Entry item = (Map.Entry) i3.next();
			System.out.println(item.getKey() + " -> " + item.getValue());
		}
		Set s4 = hurriyetmap.entrySet();
		Iterator i4 = s4.iterator();
		while (i4.hasNext()) {
			Map.Entry item = (Map.Entry) i4.next();
			System.out.println(item.getKey() + " -> " + item.getValue());
		}
		Set s5 = ulusalKanalMap.entrySet();
		Iterator i5 = s5.iterator();
		while (i5.hasNext()) {
			Map.Entry item = (Map.Entry) i5.next();
			System.out.println(item.getKey() + " -> " + item.getValue());
		}
		System.out.println("-----------------------------------");
	}

	// get only rows where cell values contain search string
	public static List<Row> getRows(Sheet sheet, DataFormatter formatter, FormulaEvaluator evaluator,
			String searchValue) {
		List<Row> result = new ArrayList<Row>();
		String cellValue = "";
		for (Row row : sheet) {
			for (Cell cell : row) {
				cellValue = formatter.formatCellValue(cell, evaluator);
				if (cellValue.contains(searchValue)) {
					result.add(row);
					break;
				}
			}
		}
		return result;
	}

//----------------------------------------
	public static void ReadInvoices() {
		// C:\Users\ALPARSLAN\Desktop\deneme.xlsx
		// C:\\Users\\ALPARSLAN\\Downloads\\Universite_Listesi.xlsx
		final String NAME = "C:\\Users\\ALPARSLAN\\Desktop\\deneme.xlsx";
		try {
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();

			// ArrayList<String> all_uni = new ArrayList<String>();

			while (sheets.hasNext()) {
				Sheet sh = sheets.next();
				System.out.println("Sheet name is : " + sh.getSheetName());
				System.out.println("-------");
				Iterator<Row> iterator = sh.iterator();

				while (iterator.hasNext()) {
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.iterator();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						// if (cell.getCellType() == CellType.STRING) {
						//
						// }
						System.out.println(cellValue + "");
						all_uni.add(cellValue);
					}
					// System.out.println();
				}
				System.out.println("----------ArrayList Content-----------");
				for (int i = 0; i < all_uni.size(); i++) {
					System.out.println(all_uni.get(i));
				}
			}

			workbook.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

//----------------------------------------
	public static ArrayList<String> getAllUni() {
		// C:\Users\ALPARSLAN\Desktop\deneme.xlsx
		// C:\\Users\\ALPARSLAN\\Downloads\\Universite_Listesi.xlsx
		final String NAME = "C:\\Users\\ALPARSLAN\\Desktop\\deneme.xlsx";
		ArrayList<String> strArray = new ArrayList<String>();
		try {
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();

			while (sheets.hasNext()) {
				Sheet sh = sheets.next();
				Iterator<Row> iterator = sh.iterator();

				while (iterator.hasNext()) {
					Row row = iterator.next();
					Iterator<Cell> cellIterator = row.iterator();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						String cellValue = dataFormatter.formatCellValue(cell);
						if (cell.getCellType() == CellType.STRING) {
							strArray.add(cellValue);
						}
					}
				}
			}

			workbook.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return strArray;
	}
//----------------------------------------

//----------------------------------------
	// İstanbul Medipol Ünviversitesinden sonra büyük boşluklar birakarak ekrana
	// yazdırıyor.Bu sıkıntı
	public static void ReadExcelFile() throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook workbook = WorkbookFactory
				.create(new FileInputStream("C:\\Users\\ALPARSLAN\\Downloads\\Universite_Listesi.xlsx"));
		// Workbook workbook = WorkbookFactory.create(new
		// FileInputStream("./inputFile.xls"));
		DataFormatter formatter = new DataFormatter();
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		Sheet sheet = workbook.getSheetAt(0);

		List<Row> filteredRows = getRows(sheet, formatter, evaluator, "İzmir");

		ArrayList<String> all_uni = new ArrayList<String>();

		for (Row row : filteredRows) {
			for (Cell cell : row) {
				System.out.print(formatter.formatCellValue(cell, evaluator));
				// System.out.print(cell.getAddress() + ":" + formatter.formatCellValue(cell,
				// evaluator));
				// System.out.print(" ");
				all_uni.add(formatter.formatCellValue(cell, evaluator));
				// System.out.println("\nCell Value : " + cell);
			}
			// System.out.println();
		}

		System.out.println("----------ArrayList Content-----------");
		for (int i = 0; i < all_uni.size(); i++) {
			System.out.println(all_uni.get(i));
		}

		workbook.close();
	}

	public static void SearchUniFromNews(String text, String searchValue) {
		int len_t = text.length();
		int len_searchValue = searchValue.length();

		int k = 0, i = 0, j = 0;

		// Loop to fin out the position Of searched "searchValue"
		for (i = 0; i <= (len_t - len_searchValue); i++) {
			for (j = 0; j < len_searchValue; j++) {
				if (text.charAt(i + j) != searchValue.charAt(j))
					break;
			}

			if (j == len_searchValue) {
				k++;
				System.out.println("Search Value Found at Position : " + i);
			}
		}

		if (k == 0)
			System.out.println("No Match Found !");
		else
			System.out.println("Total Instances Found : " + k);
	}
}
