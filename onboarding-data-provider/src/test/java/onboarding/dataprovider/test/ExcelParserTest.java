//package onboarding.dataprovider.test;
//
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import onboarding.common.Log;
//import onboarding.dataprovider.exceptions.*;
//import onboarding.dataprovider.xlsx.Conditions;
//import onboarding.dataprovider.xlsx.ExcelParser;
//
//public class ExcelParserTest {
//
//    private static String excelFilePath = System.getProperty("user.dir") + "/dev-data/API_template_20190109.xlsx";
//    private Log log = new Log(ExcelParserTest.class);
//
//    @BeforeClass
//    public void setupClass() {
//
//    }
//
//    @Test
//    public void testConstructor() {
//        ExcelParser excelParser = null;
//        excelParser = new ExcelParser(null);
//        excelParser = new ExcelParser("invalid path");
//        excelParser = new ExcelParser(excelFilePath);
//    }
//
//
//    // setValues(String sheetName, Conditions conditions, String targetColumn, String valueToSet)
//    @Test
//    public void testSetValue() {
//        ExcelParser excelParser = null;
//        excelParser = new ExcelParser(excelFilePath);
//        excelParser.setFirstRowIndex(10);
//
//        // valid conditions
//        Conditions conditions = new Conditions();
//        conditions.addCondition("API", "API1");
//        conditions.addCondition("Scope", "Test");
//
//        // invalid condition (1 or multiple conditions are not correct)
//        Conditions invalidCondition = new Conditions();
//        invalidCondition.addCondition("Invalid key", "invalid value");
//
//        String validSheetName = "Example";
//        String targetColumn = "TestCase";
//        String valueToSet = "Test" + System.currentTimeMillis();
//        String invalidSheetName = "invalid";
//        String invalidColumnName = "invalid";
//
//        try {
//            excelParser.setValue(null, conditions, 0, targetColumn, valueToSet);
//            Assert.fail();
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            // do nothing here
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.setValue(invalidSheetName, conditions, 0, targetColumn, valueToSet);
//            Assert.fail();
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            // do nothing here
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.setValue(validSheetName, null, 0, targetColumn, valueToSet);
//            Assert.fail();
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            // do nothing here
//        }
//
//        try {
//            excelParser.setValue(validSheetName, new Conditions(), 0, targetColumn, valueToSet);
//            Assert.fail();
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            // do nothing here
//        }
//
//        try {
//            excelParser.setValue(validSheetName, invalidCondition, 0, targetColumn, valueToSet);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            //do nothing
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.setValue(validSheetName, conditions, 100, targetColumn, valueToSet);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            //do nothing
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.setValue(validSheetName, conditions, 0, null, valueToSet);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            // do nothing here
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.setValue(validSheetName, conditions, 0, null, valueToSet);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            // do nothing here
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.setValue(validSheetName, conditions, 0, invalidColumnName, valueToSet);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            // do nothing here
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.setValue(validSheetName, conditions, 0, targetColumn, null);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            // do nothing here
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.setValue(validSheetName, conditions, 0, targetColumn, valueToSet);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        conditions.addCondition("Scope", "Test");
//        try {
//            excelParser.setValue(validSheetName, conditions, 0, targetColumn, valueToSet);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
//
//    // getValues(String sheetName, Conditions conditions, String targetColumn, String valueToSet)
//    @Test
//    public void testGetValue() {
//        ExcelParser excelParser = null;
//        excelParser = new ExcelParser(excelFilePath);
//        excelParser.setFirstRowIndex(10);
//
//        // valid conditions
//        Conditions conditions = new Conditions();
//        conditions.addCondition("API", "API1");
//        conditions.addCondition("Scope", "Test");
//
//        // invalid condition (1 or multiple conditions are not correct)
//        Conditions invalidCondition = new Conditions();
//        invalidCondition.addCondition("Invalid key", "invalid value");
//
//        String validSheetName = "Example";
//        String targetColumn = "TestCase";
//        String valueToSet = "Test" + System.currentTimeMillis();
//        String invalidSheetName = "invalid";
//        String invalidColumnName = "invalid";
//
//        try {
//            excelParser.getValue(null, conditions, 0, targetColumn);
//            Assert.fail();
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            // do nothing here
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.getValue(invalidSheetName, conditions, 0, targetColumn);
//            Assert.fail();
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            // do nothing here
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.getValue(validSheetName, null, 0, targetColumn);
//            Assert.fail();
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            // do nothing here
//        }
//
//        try {
//            excelParser.getValue(validSheetName, new Conditions(), 0, targetColumn);
//            Assert.fail();
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            // do nothing here
//        }
//
//        try {
//            excelParser.getValue(validSheetName, invalidCondition, 0, targetColumn);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch(IndexOutOfBoundsException e){
//
//        }
//
//        try {
//            excelParser.getValue(validSheetName, conditions, 0, null);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            // do nothing here
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.getValue(validSheetName, conditions, 0, null);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            // do nothing here
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//
//        try {
//            excelParser.getValue(validSheetName, conditions, 0, invalidColumnName);
//        } catch (WorkbookNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//            Assert.fail();
//        } catch (CellNotFoundException e) {
//            // do nothing here
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
//
//    @Test
//    public void testGetRowIndexes(){
//        ExcelParser excelParser = new ExcelParser(excelFilePath);
//        excelParser.setFirstRowIndex(10);
//
////        excelParser.getRowIndexes("Example)
//        Conditions conditions = null;
//        try {
//            excelParser.getRowIndexes("Example", conditions);
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//        } catch (ConditionsException ConditionsException) {
//            //do nothing
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        conditions = new Conditions();
//        try {
//            excelParser.getRowIndexes("Example", conditions);
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//        } catch (ConditionsException ConditionsException) {
//            //do nothing
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        conditions.addCondition("invalid key", "API1");
//        try {
//            Assert.assertEquals(0, excelParser.getRowIndexes("Example", conditions).size());
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//        }
//        conditions.removeCondition("invalid key");
//
//        conditions.addCondition("API", "invalid");
//        try {
//            Assert.assertEquals(0, excelParser.getRowIndexes("Example", conditions).size());
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//        } catch (ConditionsException e) {
//            e.printStackTrace();
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//        }
//        conditions.removeCondition("API");
//
//        conditions.addCondition("API", "API1");
//        try {
//            Assert.assertEquals(4, excelParser.getRowIndexes("Example", conditions).size());
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//        } catch (ConditionsException ConditionsException) {
//            //do nothing
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Assert.assertEquals(0, excelParser.getRowIndexes("invalid", conditions).size());
//            Assert.assertEquals(0, excelParser.getRowIndexes(null, conditions).size());
//        } catch (WorksheetNotFoundException e) {
//            e.printStackTrace();
//        } catch (RowNotFoundException e) {
//            e.printStackTrace();
//        } catch (ConditionsException ConditionsException) {
//            //do nothing
//        } catch (CellNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
//
