package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssuesUpdateMetricImagePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectIssuesUpdateMetricImagePayloadBuilder builder =
                GitLabProjectIssuesUpdateMetricImagePayloadBuilder.builder(
                                IssuesCatalogFixtures.projectIssuesUpdateMetricImagePayload())
                        .url(null);

        final GitLabProjectIssuesUpdateMetricImagePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlTextIsNullable() {
        final GitLabProjectIssuesUpdateMetricImagePayloadBuilder builder =
                GitLabProjectIssuesUpdateMetricImagePayloadBuilder.builder(
                                IssuesCatalogFixtures.projectIssuesUpdateMetricImagePayload())
                        .urlText(null);

        final GitLabProjectIssuesUpdateMetricImagePayload built = builder.build();

        assertThat(built.urlText()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssuesUpdateMetricImagePayload value =
                IssuesCatalogFixtures.projectIssuesUpdateMetricImagePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.urlText()).isEqualTo("url_text");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssuesUpdateMetricImagePayload original =
                IssuesCatalogFixtures.projectIssuesUpdateMetricImagePayload();

        final GitLabProjectIssuesUpdateMetricImagePayload rebuilt =
                GitLabProjectIssuesUpdateMetricImagePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssuesUpdateMetricImagePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "urlText");
    }
}
