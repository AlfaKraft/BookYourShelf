package com.tieto.bookyourshelf.library.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class isbnDataReader {


    public static void jsonToHash(String isbn) throws IOException {

        //String inputString = "{\"name\":\"mkyong\",\"age\":38,\"position\":[\"Founder\",\"CTO\",\"Writer\"],\"skills\":[\"java\",\"python\",\"node\",\"kotlin\"],\"salary\":{\"2018\":14000,\"2012\":12000,\"2010\":10000}}";
        String inputString = "{\"ISBN:9780980200447\": {\"info_url\": \"https://openlibrary.org/books/OL22853304M/Slow_reading\", \"bib_key\": \"ISBN:9780980200447\", \"preview_url\": \"https://archive.org/details/slowreading00mied\", \"thumbnail_url\": \"https://covers.openlibrary.org/b/id/5546156-S.jpg\", \"details\": {\"number_of_pages\": 92, \"table_of_contents\": [{\"title\": \"The personal nature of slow reading\", \"type\": {\"key\": \"/type/toc_item\"}, \"level\": 0}, {\"title\": \"Slow reading in an information ecology\", \"type\": {\"key\": \"/type/toc_item\"}, \"level\": 0}, {\"title\": \"The slow movement and slow reading\", \"type\": {\"key\": \"/type/toc_item\"}, \"level\": 0}, {\"title\": \"The psychology of slow reading\", \"type\": {\"key\": \"/type/toc_item\"}, \"level\": 0}, {\"title\": \"The practice of slow reading.\", \"type\": {\"key\": \"/type/toc_item\"}, \"level\": 0}], \"contributors\": [{\"role\": \"Cover Photographs\", \"name\": \"C. Ekholm\"}], \"isbn_10\": [\"1936117363\"], \"covers\": [5546156], \"lc_classifications\": [\"Z1003 .M58 2009\"], \"latest_revision\": 22, \"ocaid\": \"slowreading00mied\", \"weight\": \"1 grams\", \"source_records\": [\"marc:marc_loc_updates/v37.i01.records.utf8:4714764:907\", \"marc:marc_loc_updates/v37.i24.records.utf8:7913973:914\", \"marc:marc_loc_updates/v37.i30.records.utf8:11406606:914\", \"ia:slowreading00mied\", \"marc:marc_openlibraries_sanfranciscopubliclibrary/sfpl_chq_2018_12_24_run04.mrc:135742902:2094\"], \"title\": \"Slow reading\", \"languages\": [{\"key\": \"/languages/eng\"}], \"subjects\": [\"Books and reading\", \"Reading\"], \"publish_country\": \"mnu\", \"by_statement\": \"by John Miedema.\", \"oclc_numbers\": [\"297222669\"], \"type\": {\"key\": \"/type/edition\"}, \"physical_dimensions\": \"7.81 x 5.06 x 1 inches\", \"revision\": 22, \"publishers\": [\"Litwin Books\"], \"description\": \"\\\"A study of voluntary slow reading from diverse angles\\\"--Provided by publisher.\", \"physical_format\": \"Paperback\", \"last_modified\": {\"type\": \"/type/datetime\", \"value\": \"2019-07-16T22:44:09.608703\"}, \"key\": \"/books/OL22853304M\", \"authors\": [{\"name\": \"John Miedema\", \"key\": \"/authors/OL6548935A\"}], \"publish_places\": [\"Duluth, Minn\"], \"pagination\": \"80p.\", \"classifications\": {}, \"created\": {\"type\": \"/type/datetime\", \"value\": \"2009-01-07T22:16:11.381678\"}, \"lccn\": [\"2008054742\"], \"notes\": \"Includes bibliographical references and index.\", \"identifiers\": {\"amazon\": [\"098020044X\"], \"google\": [\"4LQU1YwhY6kC\"], \"goodreads\": [\"6383507\"], \"librarything\": [\"8071257\"]}, \"isbn_13\": [\"9780980200447\", \"9781936117369\"], \"dewey_decimal_class\": [\"028/.9\"], \"local_id\": [\"urn:sfpl:31223095026424\"], \"publish_date\": \"March 2009\", \"works\": [{\"key\": \"/works/OL13694821W\"}]}, \"preview\": \"borrow\"}}";
        HashMap<String,Object> result =
                new ObjectMapper().readValue(inputString, HashMap.class);

        System.out.println(result.get("ISBN:"+isbn));

        String result2 = result.get("ISBN:"+isbn).toString();

        System.out.println(result2);


        result2 = result2.substring(1, result2.length()-1);
        System.out.println(result2);
        String[] keyValuePairs = result2.split(",");
        System.out.println(keyValuePairs[4]);
        Map<String,String> map = new HashMap<>();

        for(String pair : keyValuePairs)                        //iterate over the pairs
        {

            String[] entry = pair.split("=");
            System.out.println(entry[0]);
            System.out.println(entry[1]);
            map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
        }

        System.out.println(map);
    }

    public static void main(String[] args) throws IOException {
        jsonToHash("9780980200447");
    }
}