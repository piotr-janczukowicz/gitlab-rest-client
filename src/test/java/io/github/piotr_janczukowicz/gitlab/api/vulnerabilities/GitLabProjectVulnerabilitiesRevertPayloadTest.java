package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectVulnerabilitiesRevertPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCommentIsNullable() {
        final GitLabProjectVulnerabilitiesRevertPayloadBuilder builder =
                GitLabProjectVulnerabilitiesRevertPayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesRevertPayload())
                        .comment(null);

        final GitLabProjectVulnerabilitiesRevertPayload built = builder.build();

        assertThat(built.comment()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectVulnerabilitiesRevertPayload value =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesRevertPayload();

        assertThat(value.comment()).isEqualTo("comment");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectVulnerabilitiesRevertPayload original =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesRevertPayload();

        final GitLabProjectVulnerabilitiesRevertPayload rebuilt =
                GitLabProjectVulnerabilitiesRevertPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectVulnerabilitiesRevertPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("comment");
    }
}
