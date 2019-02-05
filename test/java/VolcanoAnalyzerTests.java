import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VolcanoAnalyzerTests {
    @Test
    public void volcanoExists() {
        //Setup
        Volcano classUnderTest = new Volcano();

        //Execute


        //Assert
        Assert.assertNotNull(classUnderTest);

        //Teardown
    }


    /*

    @Test
    public void volcanoListIsLoaded() throws IOException, URISyntaxException {
        //Setup
        Integer expected = 804;
        VolcanoAnalyzer classUnderTest = new VolcanoAnalyzer();
        classUnderTest.loadVolcanos(Optional.empty());

        //Execute
        Integer actual = classUnderTest.numVolcanos();

        //Assert
        Assert.assertEquals("should have 804 volcanoes", expected, actual);

        //Teardown

    }

    */

        @Test
        public void returnVolcanoesFrom80s() {

            //setup
            VolcanoAnalyzer va = new VolcanoAnalyzer();

            Volcano v1 = new Volcano();
            v1.setName("Krakatoa");
            v1.setYear(1980);

            Volcano v2 = new Volcano();
            v2.setName("Mt. St. Helens");
            v2.setYear(1990);

            List<Volcano> testData = Arrays.asList(v1, v2);

            va.setVolcanoes(testData);

            List<Volcano> expected = Arrays.asList(v1);

            // Exercise
            List<Volcano> actual = va.returnVolcanoesFrom(1980, 1989);

            // Assert
            assertEquals("Should return only volcanoes that erupted in the 80's", expected, actual);
        }




        @Test
        public void returnVolcanoNamesWithVei6() {


            VolcanoAnalyzer va = new VolcanoAnalyzer();

            List<Volcano> dataList = new ArrayList<>();

            Volcano v1 = new Volcano();
            v1.setName("Krakatoa");
            v1.setYear(1980);
            v1.setVEI(6);

            Volcano v2 = new Volcano();
            v2.setName("Mt. St. Helens");
            v2.setYear(1990);
            v2.setVEI(4);

            Volcano v3 = new Volcano();
            v3.setName("Nikitha");
            v3.setYear(1993);
            v3.setVEI(9);

            Volcano v4 = new Volcano();
            v4.setName("Mohammed");
            v4.setYear(1994);
            v4.setVEI(2);

            Volcano v5 = new Volcano();
            v5.setName("kilimajaro");
            v5.setYear(1991);
            v5.setVEI(6);



            //setup
            List<Volcano> testData = Arrays.asList(v1, v2, v3, v4, v5);
            va.setVolcanoes(testData);
            String[] expected = {"kilimajaro", "Nikitha", "Krakatoa"};

            String[] actual = va.returnVolcanoNamesWithVei(6);
            //assert
            Assert.assertEquals("only return vei 6 or higher", expected, actual);
        }



        @Test
        public void returnHighestNumberDeaths() {
        // Setup


            VolcanoAnalyzer va = new VolcanoAnalyzer();

            List<Volcano> someList = new ArrayList<>();

            Volcano v1 = new Volcano();
            v1.setName("Krakatoa");
            v1.setDEATHS("ten");

            Volcano v2 = new Volcano();
            v2.setName("Mt. St. Helens");
            v2.setDEATHS("five");

            Volcano v3 = new Volcano();
            v3.setName("Nikitha");
            v3.setDEATHS("twelve");




            List<Volcano> someList = Arrays.asList(v1, v2, v3);
            va.setVolcanoes(someList);
            String[] expected = {"Nikitha"};

            String[] actual = va.returnHighestNumberDeaths();
            //assert
            Assert.assertEquals("should return eruption with highest number of deaths", expected, actual);
        }


    }

