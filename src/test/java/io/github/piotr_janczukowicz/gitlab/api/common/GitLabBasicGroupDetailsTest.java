package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBasicGroupDetailsTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBasicGroupDetailsBuilder builder = GitLabBasicGroupDetailsBuilder.builder(
                        CommonCatalogFixtures.basicGroupDetails())
                .id(null);

        final GitLabBasicGroupDetails built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabBasicGroupDetailsBuilder builder = GitLabBasicGroupDetailsBuilder.builder(
                        CommonCatalogFixtures.basicGroupDetails())
                .webUrl(null);

        final GitLabBasicGroupDetails built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabBasicGroupDetailsBuilder builder = GitLabBasicGroupDetailsBuilder.builder(
                        CommonCatalogFixtures.basicGroupDetails())
                .name(null);

        final GitLabBasicGroupDetails built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBasicGroupDetails value = CommonCatalogFixtures.basicGroupDetails();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.webUrl()).isEqualTo("http://gitlab.example.com/groups/diaspora");
            softly.assertThat(value.name()).isEqualTo("Diaspora");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBasicGroupDetails original = CommonCatalogFixtures.basicGroupDetails();

        final GitLabBasicGroupDetails rebuilt =
                GitLabBasicGroupDetailsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBasicGroupDetails.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "webUrl", "name");
    }
}
