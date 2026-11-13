package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBasicSuccessTest {

    @Test
    void constructor_shouldAcceptNull_whenSuccessIsNullable() {
        final GitLabBasicSuccessBuilder builder = GitLabBasicSuccessBuilder.builder(
                        CommonCatalogFixtures.basicSuccess())
                .success(null);

        final GitLabBasicSuccess built = builder.build();

        assertThat(built.success()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBasicSuccess value = CommonCatalogFixtures.basicSuccess();

        assertThat(value.success()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBasicSuccess original = CommonCatalogFixtures.basicSuccess();

        final GitLabBasicSuccess rebuilt =
                GitLabBasicSuccessBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBasicSuccess.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("success");
    }
}
