package io.github.piotr_janczukowicz.gitlab.api.useremailaddresses;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserEmailAddressesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabUserEmailAddressesCreatePayloadBuilder builder =
                GitLabUserEmailAddressesCreatePayloadBuilder.builder(
                                UseremailaddressesCatalogFixtures.userEmailAddressesCreatePayload())
                        .email(null);

        final GitLabUserEmailAddressesCreatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserEmailAddressesCreatePayload value =
                UseremailaddressesCatalogFixtures.userEmailAddressesCreatePayload();

        assertThat(value.email()).isEqualTo("email");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserEmailAddressesCreatePayload original =
                UseremailaddressesCatalogFixtures.userEmailAddressesCreatePayload();

        final GitLabUserEmailAddressesCreatePayload rebuilt =
                GitLabUserEmailAddressesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserEmailAddressesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("email");
    }
}
