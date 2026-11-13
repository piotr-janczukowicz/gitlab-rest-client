package io.github.piotr_janczukowicz.gitlab.api.goproxy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGoModuleVersionTest {

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabGoModuleVersionBuilder builder = GitLabGoModuleVersionBuilder.builder(
                        GoproxyCatalogFixtures.goModuleVersion())
                .version(null);

        final GitLabGoModuleVersion built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeIsNullable() {
        final GitLabGoModuleVersionBuilder builder = GitLabGoModuleVersionBuilder.builder(
                        GoproxyCatalogFixtures.goModuleVersion())
                .time(null);

        final GitLabGoModuleVersion built = builder.build();

        assertThat(built.time()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGoModuleVersion value = GoproxyCatalogFixtures.goModuleVersion();

        assertSoftly(softly -> {
            softly.assertThat(value.version()).isEqualTo("v1.0.0");
            softly.assertThat(value.time()).isEqualTo("1617822312 -0600");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGoModuleVersion original = GoproxyCatalogFixtures.goModuleVersion();

        final GitLabGoModuleVersion rebuilt =
                GitLabGoModuleVersionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGoModuleVersion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("version", "time");
    }
}
