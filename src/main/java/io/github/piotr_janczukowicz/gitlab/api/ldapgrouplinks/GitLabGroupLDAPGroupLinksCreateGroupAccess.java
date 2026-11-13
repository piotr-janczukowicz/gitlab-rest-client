package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group ldapgroup links create group access. */
@CatalogSchema("operations/postApiV4GroupsIdLdapGroupLinks/requestBody/properties/group_access")
public enum GitLabGroupLDAPGroupLinksCreateGroupAccess {
    N_5(5),
    N_10(10),
    N_15(15),
    N_20(20),
    N_25(25),
    N_30(30),
    N_40(40),
    N_50(50);

    private static final EnumUtils.WireIndex<GitLabGroupLDAPGroupLinksCreateGroupAccess> WIRE_INDEX = EnumUtils.index(
            GitLabGroupLDAPGroupLinksCreateGroupAccess.class, value -> String.valueOf(value.wireValue()));

    private final int wireValue;

    GitLabGroupLDAPGroupLinksCreateGroupAccess(final int wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public int wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabGroupLDAPGroupLinksCreateGroupAccess fromWire(final int value) {
        return WIRE_INDEX
                .fromWire(String.valueOf(value))
                .orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
