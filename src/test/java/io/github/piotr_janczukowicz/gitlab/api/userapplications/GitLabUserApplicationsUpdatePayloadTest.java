package io.github.piotr_janczukowicz.gitlab.api.userapplications;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserApplicationsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserApplicationsUpdatePayloadBuilder builder = GitLabUserApplicationsUpdatePayloadBuilder.builder(
                        UserapplicationsCatalogFixtures.userApplicationsUpdatePayload())
                .name(null);

        final GitLabUserApplicationsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabUserApplicationsUpdatePayloadBuilder builder = GitLabUserApplicationsUpdatePayloadBuilder.builder(
                        UserapplicationsCatalogFixtures.userApplicationsUpdatePayload())
                .scopes(null);

        final GitLabUserApplicationsUpdatePayload built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserApplicationsUpdatePayload value =
                UserapplicationsCatalogFixtures.userApplicationsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.scopes()).isEqualTo("scopes");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserApplicationsUpdatePayload original =
                UserapplicationsCatalogFixtures.userApplicationsUpdatePayload();

        final GitLabUserApplicationsUpdatePayload rebuilt =
                GitLabUserApplicationsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserApplicationsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "scopes");
    }
}
