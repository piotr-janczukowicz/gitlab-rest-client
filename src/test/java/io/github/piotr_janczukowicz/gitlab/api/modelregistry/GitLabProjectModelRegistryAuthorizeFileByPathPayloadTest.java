package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectModelRegistryAuthorizeFileByPathPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectModelRegistryAuthorizeFileByPathPayloadBuilder builder =
                GitLabProjectModelRegistryAuthorizeFileByPathPayloadBuilder.builder(
                                ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFileByPathPayload())
                        .status(null);

        final GitLabProjectModelRegistryAuthorizeFileByPathPayload built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectModelRegistryAuthorizeFileByPathPayload value =
                ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFileByPathPayload();

        assertThat(value.status()).isEqualTo(GitLabProjectModelRegistryAuthorizeFileByPathStatus.DEFAULT);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectModelRegistryAuthorizeFileByPathPayload original =
                ModelregistryCatalogFixtures.projectModelRegistryAuthorizeFileByPathPayload();

        final GitLabProjectModelRegistryAuthorizeFileByPathPayload rebuilt =
                GitLabProjectModelRegistryAuthorizeFileByPathPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectModelRegistryAuthorizeFileByPathPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }
}
