package io.github.piotr_janczukowicz.gitlab.api.epiclinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupEpicLinksUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenMoveBeforeIdIsNullable() {
        final GitLabGroupEpicLinksUpdatePayloadBuilder builder = GitLabGroupEpicLinksUpdatePayloadBuilder.builder(
                        EpiclinksCatalogFixtures.groupEpicLinksUpdatePayload())
                .moveBeforeId(null);

        final GitLabGroupEpicLinksUpdatePayload built = builder.build();

        assertThat(built.moveBeforeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMoveAfterIdIsNullable() {
        final GitLabGroupEpicLinksUpdatePayloadBuilder builder = GitLabGroupEpicLinksUpdatePayloadBuilder.builder(
                        EpiclinksCatalogFixtures.groupEpicLinksUpdatePayload())
                .moveAfterId(null);

        final GitLabGroupEpicLinksUpdatePayload built = builder.build();

        assertThat(built.moveAfterId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupEpicLinksUpdatePayload value = EpiclinksCatalogFixtures.groupEpicLinksUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.moveBeforeId()).isEqualTo(1L);
            softly.assertThat(value.moveAfterId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupEpicLinksUpdatePayload original = EpiclinksCatalogFixtures.groupEpicLinksUpdatePayload();

        final GitLabGroupEpicLinksUpdatePayload rebuilt =
                GitLabGroupEpicLinksUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupEpicLinksUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("moveBeforeId", "moveAfterId");
    }
}
