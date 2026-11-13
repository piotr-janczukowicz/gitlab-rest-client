package io.github.piotr_janczukowicz.gitlab.api.groupsshcertificates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupSSHCertificatesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupGroupSSHCertificatesCreatePayloadBuilder builder =
                GitLabGroupGroupSSHCertificatesCreatePayloadBuilder.builder(
                                GroupsshcertificatesCatalogFixtures.groupGroupSSHCertificatesCreatePayload())
                        .title(null);

        final GitLabGroupGroupSSHCertificatesCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabGroupGroupSSHCertificatesCreatePayloadBuilder builder =
                GitLabGroupGroupSSHCertificatesCreatePayloadBuilder.builder(
                                GroupsshcertificatesCatalogFixtures.groupGroupSSHCertificatesCreatePayload())
                        .key(null);

        final GitLabGroupGroupSSHCertificatesCreatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupSSHCertificatesCreatePayload value =
                GroupsshcertificatesCatalogFixtures.groupGroupSSHCertificatesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.key()).isEqualTo("key");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupSSHCertificatesCreatePayload original =
                GroupsshcertificatesCatalogFixtures.groupGroupSSHCertificatesCreatePayload();

        final GitLabGroupGroupSSHCertificatesCreatePayload rebuilt =
                GitLabGroupGroupSSHCertificatesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupSSHCertificatesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "key");
    }
}
