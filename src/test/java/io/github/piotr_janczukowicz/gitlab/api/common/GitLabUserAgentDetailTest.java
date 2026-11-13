package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserAgentDetailTest {

    @Test
    void constructor_shouldAcceptNull_whenUserAgentIsNullable() {
        final GitLabUserAgentDetailBuilder builder = GitLabUserAgentDetailBuilder.builder(
                        CommonCatalogFixtures.userAgentDetail())
                .userAgent(null);

        final GitLabUserAgentDetail built = builder.build();

        assertThat(built.userAgent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIpAddressIsNullable() {
        final GitLabUserAgentDetailBuilder builder = GitLabUserAgentDetailBuilder.builder(
                        CommonCatalogFixtures.userAgentDetail())
                .ipAddress(null);

        final GitLabUserAgentDetail built = builder.build();

        assertThat(built.ipAddress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAkismetSubmittedIsNullable() {
        final GitLabUserAgentDetailBuilder builder = GitLabUserAgentDetailBuilder.builder(
                        CommonCatalogFixtures.userAgentDetail())
                .akismetSubmitted(null);

        final GitLabUserAgentDetail built = builder.build();

        assertThat(built.akismetSubmitted()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserAgentDetail value = CommonCatalogFixtures.userAgentDetail();

        assertSoftly(softly -> {
            softly.assertThat(value.userAgent()).isEqualTo("AppleWebKit/537.36");
            softly.assertThat(value.ipAddress()).isEqualTo("127.0.0.1");
            softly.assertThat(value.akismetSubmitted()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserAgentDetail original = CommonCatalogFixtures.userAgentDetail();

        final GitLabUserAgentDetail rebuilt =
                GitLabUserAgentDetailBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserAgentDetail.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("userAgent", "ipAddress", "akismetSubmitted");
    }
}
