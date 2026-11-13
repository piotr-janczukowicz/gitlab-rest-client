package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespacesCreateStorageLimitExclusionPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenReasonIsNullable() {
        final GitLabNamespacesCreateStorageLimitExclusionPayloadBuilder builder =
                GitLabNamespacesCreateStorageLimitExclusionPayloadBuilder.builder(
                                NamespacesCatalogFixtures.namespacesCreateStorageLimitExclusionPayload())
                        .reason(null);

        final GitLabNamespacesCreateStorageLimitExclusionPayload built = builder.build();

        assertThat(built.reason()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespacesCreateStorageLimitExclusionPayload value =
                NamespacesCatalogFixtures.namespacesCreateStorageLimitExclusionPayload();

        assertThat(value.reason()).isEqualTo("reason");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespacesCreateStorageLimitExclusionPayload original =
                NamespacesCatalogFixtures.namespacesCreateStorageLimitExclusionPayload();

        final GitLabNamespacesCreateStorageLimitExclusionPayload rebuilt =
                GitLabNamespacesCreateStorageLimitExclusionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabNamespacesCreateStorageLimitExclusionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("reason");
    }
}
