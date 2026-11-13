package io.github.piotr_janczukowicz.gitlab.api.tokenexchange;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTokenExchangeCreatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenAudienceIsNull() {
        final GitLabTokenExchangeCreatePayloadBuilder builder = GitLabTokenExchangeCreatePayloadBuilder.builder(
                        TokenexchangeCatalogFixtures.tokenExchangeCreatePayload())
                .audience(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("audience");
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresInIsNullable() {
        final GitLabTokenExchangeCreatePayloadBuilder builder = GitLabTokenExchangeCreatePayloadBuilder.builder(
                        TokenexchangeCatalogFixtures.tokenExchangeCreatePayload())
                .expiresIn(null);

        final GitLabTokenExchangeCreatePayload built = builder.build();

        assertThat(built.expiresIn()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenExpiresInIsBelowTheMinimum() {
        final GitLabTokenExchangeCreatePayloadBuilder builder = GitLabTokenExchangeCreatePayloadBuilder.builder(
                        TokenexchangeCatalogFixtures.tokenExchangeCreatePayload())
                .expiresIn(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenExpiresInIsTheMinimum() {
        final GitLabTokenExchangeCreatePayloadBuilder builder = GitLabTokenExchangeCreatePayloadBuilder.builder(
                        TokenexchangeCatalogFixtures.tokenExchangeCreatePayload())
                .expiresIn(1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenExpiresInIsAboveTheMaximum() {
        final GitLabTokenExchangeCreatePayloadBuilder builder = GitLabTokenExchangeCreatePayloadBuilder.builder(
                        TokenexchangeCatalogFixtures.tokenExchangeCreatePayload())
                .expiresIn(43_201);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenExpiresInIsTheMaximum() {
        final GitLabTokenExchangeCreatePayloadBuilder builder = GitLabTokenExchangeCreatePayloadBuilder.builder(
                        TokenexchangeCatalogFixtures.tokenExchangeCreatePayload())
                .expiresIn(43_200);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTokenExchangeCreatePayload value = TokenexchangeCatalogFixtures.tokenExchangeCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.audience()).isEqualTo(GitLabTokenExchangeCreateAudience.GITLAB_ARTIFACT_REGISTRY);
            softly.assertThat(value.expiresIn()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTokenExchangeCreatePayload original = TokenexchangeCatalogFixtures.tokenExchangeCreatePayload();

        final GitLabTokenExchangeCreatePayload rebuilt =
                GitLabTokenExchangeCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTokenExchangeCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("audience", "expiresIn");
    }
}
