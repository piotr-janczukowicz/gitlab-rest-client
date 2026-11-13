package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSearchUpdateShardsIndexedNamespacePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSearchIsNullable() {
        final GitLabCodeSearchUpdateShardsIndexedNamespacePayloadBuilder builder =
                GitLabCodeSearchUpdateShardsIndexedNamespacePayloadBuilder.builder(
                                CodesearchCatalogFixtures.codeSearchUpdateShardsIndexedNamespacePayload())
                        .search(null);

        final GitLabCodeSearchUpdateShardsIndexedNamespacePayload built = builder.build();

        assertThat(built.search()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSearchUpdateShardsIndexedNamespacePayload value =
                CodesearchCatalogFixtures.codeSearchUpdateShardsIndexedNamespacePayload();

        assertThat(value.search()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSearchUpdateShardsIndexedNamespacePayload original =
                CodesearchCatalogFixtures.codeSearchUpdateShardsIndexedNamespacePayload();

        final GitLabCodeSearchUpdateShardsIndexedNamespacePayload rebuilt =
                GitLabCodeSearchUpdateShardsIndexedNamespacePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabCodeSearchUpdateShardsIndexedNamespacePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("search");
    }
}
