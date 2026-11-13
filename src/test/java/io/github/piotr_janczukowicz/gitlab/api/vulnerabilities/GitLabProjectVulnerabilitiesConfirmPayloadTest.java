package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectVulnerabilitiesConfirmPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCommentIsNullable() {
        final GitLabProjectVulnerabilitiesConfirmPayloadBuilder builder =
                GitLabProjectVulnerabilitiesConfirmPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesConfirmPayload())
                        .comment(null);

        final GitLabProjectVulnerabilitiesConfirmPayload built = builder.build();

        assertThat(built.comment()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectVulnerabilitiesConfirmPayload value =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesConfirmPayload();

        assertThat(value.comment()).isEqualTo("comment");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectVulnerabilitiesConfirmPayload original =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesConfirmPayload();

        final GitLabProjectVulnerabilitiesConfirmPayload rebuilt =
                GitLabProjectVulnerabilitiesConfirmPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectVulnerabilitiesConfirmPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("comment");
    }
}
