package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectWebhooksCallEventsStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectWebhooksCallEventsStatus.values())
                .map(GitLabProjectProjectWebhooksCallEventsStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "100",
                        "101",
                        "102",
                        "103",
                        "200",
                        "201",
                        "202",
                        "203",
                        "204",
                        "205",
                        "206",
                        "207",
                        "208",
                        "226",
                        "300",
                        "301",
                        "302",
                        "303",
                        "304",
                        "305",
                        "306",
                        "307",
                        "308",
                        "400",
                        "401",
                        "402",
                        "403",
                        "404",
                        "405",
                        "406",
                        "407",
                        "408",
                        "409",
                        "410",
                        "411",
                        "412",
                        "413",
                        "414",
                        "415",
                        "416",
                        "417",
                        "421",
                        "422",
                        "423",
                        "424",
                        "425",
                        "426",
                        "428",
                        "429",
                        "431",
                        "451",
                        "500",
                        "501",
                        "502",
                        "503",
                        "504",
                        "505",
                        "506",
                        "507",
                        "508",
                        "509",
                        "510",
                        "511",
                        "successful",
                        "client_failure",
                        "server_failure");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectWebhooksCallEventsStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectWebhooksCallEventsStatus constant) {
        final GitLabProjectProjectWebhooksCallEventsStatus decoded =
                GitLabProjectProjectWebhooksCallEventsStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectWebhooksCallEventsStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectWebhooksCallEventsStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
