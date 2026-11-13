package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabActiveContextActivateConnectionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenConnectionIdIsNullable() {
        final GitLabActiveContextActivateConnectionPayloadBuilder builder =
                GitLabActiveContextActivateConnectionPayloadBuilder.builder(
                                ActivecontextCatalogFixtures.activeContextActivateConnectionPayload())
                        .connectionId(null);

        final GitLabActiveContextActivateConnectionPayload built = builder.build();

        assertThat(built.connectionId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabActiveContextActivateConnectionPayload value =
                ActivecontextCatalogFixtures.activeContextActivateConnectionPayload();

        assertThat(value.connectionId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabActiveContextActivateConnectionPayload original =
                ActivecontextCatalogFixtures.activeContextActivateConnectionPayload();

        final GitLabActiveContextActivateConnectionPayload rebuilt =
                GitLabActiveContextActivateConnectionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabActiveContextActivateConnectionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("connectionId");
    }
}
