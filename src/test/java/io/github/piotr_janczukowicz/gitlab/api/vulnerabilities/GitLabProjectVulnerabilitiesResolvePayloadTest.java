package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectVulnerabilitiesResolvePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCommentIsNullable() {
        final GitLabProjectVulnerabilitiesResolvePayloadBuilder builder =
                GitLabProjectVulnerabilitiesResolvePayloadBuilder.builder(
                                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesResolvePayload())
                        .comment(null);

        final GitLabProjectVulnerabilitiesResolvePayload built = builder.build();

        assertThat(built.comment()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectVulnerabilitiesResolvePayload value =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesResolvePayload();

        assertThat(value.comment()).isEqualTo("comment");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectVulnerabilitiesResolvePayload original =
                VulnerabilitiesCatalogFixtures.projectVulnerabilitiesResolvePayload();

        final GitLabProjectVulnerabilitiesResolvePayload rebuilt =
                GitLabProjectVulnerabilitiesResolvePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectVulnerabilitiesResolvePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("comment");
    }
}
