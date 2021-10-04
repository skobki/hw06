package tests.assertions;

import facadeSteps.TVProductPageSteps;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;


import java.util.Arrays;
import java.util.stream.IntStream;

public class TVProductPageAssert {
    private Logger logger = LogManager.getLogger(TVProductPageAssert.class);
    TVProductPageSteps tvProductPageSteps;

    public TVProductPageAssert(TVProductPageSteps tvProductPageSteps) {
        this.tvProductPageSteps = tvProductPageSteps;
    }

    public void pageTitleEquals(String expected) {
        String actual = tvProductPageSteps.pageTitle();
        Assertions.assertEquals(expected, actual, "Ошибка. Заголовок страницы не соответствует ожидаемому");
        logger.info("Текущий заголовок страницы: " + actual);
        logger.info("Ожидаемый заголовок страницы: " + expected);
    }

    public void productCompanyEquals(String expected) {
        String actual = tvProductPageSteps.productModel();
        Assertions.assertTrue(actual.contains(expected), "Ошибка. Имя производителя не содержится в названии модели");
        logger.info("Модель: " + actual);
        logger.info("Производитель: " + expected);
    }

    public void productFrequencyEquals(String expected) {
        String actual = tvProductPageSteps.productFrequency();
        Assertions.assertEquals(expected, actual, "Ошибка. Частота обновления экрана не соответствует ожидаемой");
        logger.info("Текущая частота обновления экрана: " + actual);
        logger.info("Ожидаемая частота обновления экрана: " + expected);
    }

    public void productLedTypeEquals(String expected) {
        String actual = tvProductPageSteps.productLedType();
        Assertions.assertEquals(expected, actual, "Ошибка. Тип подсветки экрана не соответствует ожидаемому");
        logger.info("Текущая частота обновления экрана: " + actual);
        logger.info("Ожидаемая частота обновления экрана: " + expected);
    }

    public void productDiagonalEquals(int expectedMin, int expectedMax) {
        String actual = tvProductPageSteps.productDiagonal();
        String actualDecimals = actual.replaceAll("[^\\d.]", "");
        int actualDiagonal = Integer.parseInt(actualDecimals);
        int[] expectedRangeDiagonalArray = new int[expectedMax - expectedMin];
        for (int i = 0; i < (expectedMax - expectedMin); i++) {
            expectedRangeDiagonalArray[i] = expectedMin + i;
        }
        Assertions.assertTrue(ArrayUtils.contains(expectedRangeDiagonalArray, actualDiagonal), "Ошибка. Диагональ экрана не соответствует ожидаемой");
        logger.info("Текущая диагональ экрана: " + actual);
        logger.info("Диапазон ожидаемой диагонали экрана: от " + expectedMin + " до " + expectedMax);
//        if (actualDiagonal < expectedMin || actualDiagonal > expectedMax) {
//            throw new RuntimeException("Ошибка. Диагональ экрана не соответствует ожидаемой");
//        } else {
//            logger.info("Текущая диагональ экрана: " + actual);
//            logger.info("Диапазон ожидаемой диагонали экрана: от " + expectedMin + " до " + expectedMax);
//        }

    }


}
