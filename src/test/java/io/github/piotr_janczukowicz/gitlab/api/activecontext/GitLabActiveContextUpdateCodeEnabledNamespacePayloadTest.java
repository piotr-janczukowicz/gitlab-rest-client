package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabActiveContextUpdateCodeEnabledNamespacePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabActiveContextUpdateCodeEnabledNamespacePayloadBuilder builder =
                GitLabActiveContextUpdateCodeEnabledNamespacePayloadBuilder.builder(
                                ActivecontextCatalogFixtures.activeContextUpdateCodeEnabledNamespacePayload())
                        .namespaceId(null);

        final GitLabActiveContextUpdateCodeEnabledNamespacePayload built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenStateIsNull() {
        final GitLabActiveContextUpdateCodeEnabledNamespacePayloadBuilder builder =
                GitLabActiveContextUpdateCodeEnabledNamespacePayloadBuilder.builder(
                                ActivecontextCatalogFixtures.activeContextUpdateCodeEnabledNamespacePayload())
                        .state(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("state");
    }

    @Test
    void constructor_shouldAcceptNull_whenConnectionIdIsNullable() {
        final GitLabActiveContextUpdateCodeEnabledNamespacePayloadBuilder builder =
                GitLabActiveContextUpdateCodeEnabledNamespacePayloadBuilder.builder(
                                ActivecontextCatalogFixtures.activeContextUpdateCodeEnabledNamespacePayload())
                        .connectionId(null);

        final GitLabActiveContextUpdateCodeEnabledNamespacePayload built = builder.build();

        assertThat(built.connectionId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabActiveContextUpdateCodeEnabledNamespacePayload value =
                ActivecontextCatalogFixtures.activeContextUpdateCodeEnabledNamespacePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.namespaceId()).isEqualTo("text");
            softly.assertThat(value.state()).isEqualTo(GitLabActiveContextUpdateCodeEnabledNamespaceState.PENDING);
            softly.assertThat(value.connectionId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabActiveContextUpdateCodeEnabledNamespacePayload original =
                ActivecontextCatalogFixtures.activeContextUpdateCodeEnabledNamespacePayload();

        final GitLabActiveContextUpdateCodeEnabledNamespacePayload rebuilt =
                GitLabActiveContextUpdateCodeEnabledNamespacePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabActiveContextUpdateCodeEnabledNamespacePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("namespaceId", "state", "connectionId");
    }
}
