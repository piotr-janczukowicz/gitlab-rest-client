package io.github.piotr_janczukowicz.gitlab.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAnnotationValuesTest {

    @Test
    void constants_shouldHoldTheValuesOfTheAnnotations_whenRead() throws Exception {
        assertSoftly(softly -> {
            softly.assertThat(GitLabAnnotationValues.BARE_OBJECT).isEqualTo("dump is a bare object with no properties");
            softly.assertThat(GitLabAnnotationValues.XOR_INTEGER_STRING).isEqualTo("integer|string");
            softly.assertThat(GitLabAnnotationValues.XOR_STRING_ARRAY).isEqualTo("string|array");
            softly.assertThat(GitLabAnnotationValues.XOR_STRING_INTEGER).isEqualTo("string|integer");
            softly.assertThat(GitLabAnnotationValues.XOR_STRING_STRING).isEqualTo("string|string");
        });
    }

    @Test
    void constructor_shouldRefuse_whenCalled() throws Exception {
        final Constructor<GitLabAnnotationValues> constructor = GitLabAnnotationValues.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        final Throwable thrown = catchThrowable(constructor::newInstance);

        assertThat(thrown).hasCauseInstanceOf(UnsupportedOperationException.class);
    }
}
