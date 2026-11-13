package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabActiveContextDeactivateConnectionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenConnectionIdIsNullable() {
        final GitLabActiveContextDeactivateConnectionPayloadBuilder builder =
                GitLabActiveContextDeactivateConnectionPayloadBuilder.builder(
                                ActivecontextCatalogFixtures.activeContextDeactivateConnectionPayload())
                        .connectionId(null);

        final GitLabActiveContextDeactivateConnectionPayload built = builder.build();

        assertThat(built.connectionId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabActiveContextDeactivateConnectionPayload value =
                ActivecontextCatalogFixtures.activeContextDeactivateConnectionPayload();

        assertThat(value.connectionId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabActiveContextDeactivateConnectionPayload original =
                ActivecontextCatalogFixtures.activeContextDeactivateConnectionPayload();

        final GitLabActiveContextDeactivateConnectionPayload rebuilt =
                GitLabActiveContextDeactivateConnectionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabActiveContextDeactivateConnectionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("connectionId");
    }
}
