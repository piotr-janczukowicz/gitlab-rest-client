package io.github.piotr_janczukowicz.gitlab.api.epiclinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupEpicLinksCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupEpicLinksCreatePayloadBuilder builder = GitLabGroupEpicLinksCreatePayloadBuilder.builder(
                        EpiclinksCatalogFixtures.groupEpicLinksCreatePayload())
                .title(null);

        final GitLabGroupEpicLinksCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabGroupEpicLinksCreatePayloadBuilder builder = GitLabGroupEpicLinksCreatePayloadBuilder.builder(
                        EpiclinksCatalogFixtures.groupEpicLinksCreatePayload())
                .confidential(null);

        final GitLabGroupEpicLinksCreatePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupEpicLinksCreatePayload value = EpiclinksCatalogFixtures.groupEpicLinksCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("Epic title");
            softly.assertThat(value.confidential()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupEpicLinksCreatePayload original = EpiclinksCatalogFixtures.groupEpicLinksCreatePayload();

        final GitLabGroupEpicLinksCreatePayload rebuilt =
                GitLabGroupEpicLinksCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupEpicLinksCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "confidential");
    }
}
