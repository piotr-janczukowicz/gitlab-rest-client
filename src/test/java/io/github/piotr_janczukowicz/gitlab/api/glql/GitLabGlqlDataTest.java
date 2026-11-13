package io.github.piotr_janczukowicz.gitlab.api.glql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGlqlDataTest {

    @Test
    void constructor_shouldAcceptNull_whenCountIsNullable() {
        final GitLabGlqlDataBuilder builder =
                GitLabGlqlDataBuilder.builder(GlqlCatalogFixtures.glqlData()).count(null);

        final GitLabGlqlData built = builder.build();

        assertThat(built.count()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageInfoIsNullable() {
        final GitLabGlqlDataBuilder builder =
                GitLabGlqlDataBuilder.builder(GlqlCatalogFixtures.glqlData()).pageInfo(null);

        final GitLabGlqlData built = builder.build();

        assertThat(built.pageInfo()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGlqlData value = GlqlCatalogFixtures.glqlData();

        assertSoftly(softly -> {
            softly.assertThat(value.count()).isEqualTo(1);
            softly.assertThat(value.pageInfo()).isEqualTo(GlqlCatalogFixtures.glqlPageInfo());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGlqlData original = GlqlCatalogFixtures.glqlData();

        final GitLabGlqlData rebuilt = GitLabGlqlDataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGlqlData.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("count", "pageInfo");
    }
}
