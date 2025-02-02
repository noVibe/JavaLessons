package ru.codreview.tests.utils;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

class DumbUtilsTest {

    @Test
    void timeOfDay() {
        //given
        String expected = "Evening";
        LocalTime fakeTime = LocalTime.of(20, 0);

        //when
        @Cleanup MockedStatic<LocalTime> mockedStatic = mockStatic(LocalTime.class);
        mockedStatic.when(LocalTime::now).thenReturn(fakeTime);
        String actual = DumbUtils.timeOfDay();

        //then
        assertThat(expected).isEqualTo(actual);
    }

}