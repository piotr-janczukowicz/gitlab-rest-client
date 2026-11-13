package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectModelRegistryAuthorizeFilePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectModelRegistryAuthorizeFilePayloadBuilder builder =
                GitLabProjectModelRegistryAuthorizeFilePayloadBuilder.builder(
                                ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFilePayload())
                        .status(null);

        final GitLabProjectModelRegistryAuthorizeFilePayload built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectModelRegistryAuthorizeFilePayload value =
                ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFilePayload();

        assertThat(value.status()).isEqualTo(GitLabProjectModelRegistryAuthorizeFileStatus.DEFAULT);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectModelRegistryAuthorizeFilePayload original =
                ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFilePayload();

        final GitLabProjectModelRegistryAuthorizeFilePayload rebuilt =
                GitLabProjectModelRegistryAuthorizeFilePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectModelRegistryAuthorizeFilePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }
}
