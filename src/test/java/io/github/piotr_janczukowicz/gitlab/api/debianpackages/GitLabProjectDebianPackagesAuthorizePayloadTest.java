package io.github.piotr_janczukowicz.gitlab.api.debianpackages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDebianPackagesAuthorizePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDistributionIsNullable() {
        final GitLabProjectDebianPackagesAuthorizePayloadBuilder builder =
                GitLabProjectDebianPackagesAuthorizePayloadBuilder.builder(
                                DebianpackagesCatalogFixtures.projectDebianPackagesAuthorizePayload())
                        .distribution(null);

        final GitLabProjectDebianPackagesAuthorizePayload built = builder.build();

        assertThat(built.distribution()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenComponentIsNullable() {
        final GitLabProjectDebianPackagesAuthorizePayloadBuilder builder =
                GitLabProjectDebianPackagesAuthorizePayloadBuilder.builder(
                                DebianpackagesCatalogFixtures.projectDebianPackagesAuthorizePayload())
                        .component(null);

        final GitLabProjectDebianPackagesAuthorizePayload built = builder.build();

        assertThat(built.component()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDebianPackagesAuthorizePayload value =
                DebianpackagesCatalogFixtures.projectDebianPackagesAuthorizePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.distribution()).isEqualTo("distribution");
            softly.assertThat(value.component()).isEqualTo("component");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDebianPackagesAuthorizePayload original =
                DebianpackagesCatalogFixtures.projectDebianPackagesAuthorizePayload();

        final GitLabProjectDebianPackagesAuthorizePayload rebuilt =
                GitLabProjectDebianPackagesAuthorizePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDebianPackagesAuthorizePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("distribution", "component");
    }
}
