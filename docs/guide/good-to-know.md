# Good to know

Previous: [Immutability](immutability.md) · Next: [Live smoke tests](smoke-tests.md) · [Guide index](README.md)

## Names

Names follow GitLab's documentation: one `GitLab*Api` class per documentation page and scope, and method names from the
operation. Where a page serves projects, groups and the instance, the facade accessor is an aggregator with `project()`,
`group()` and `instance()`. The Javadoc of a method names the HTTP request it sends, for example
`GET /projects/{id}/repository/branches`.

## Newer GitLab data

A response enum value the library does not know decodes to `UNRECOGNIZED`, and an unknown property is ignored, so a newer
GitLab does not break an older library. Update the library to see the new data in a typed form.

## Deprecated operations

An operation that GitLab marks deprecated carries `@Deprecated`. Use the replacement that GitLab's documentation names.

## Tiers

An operation that needs a Premium or Ultimate subscription carries `@RequiresTier`. Set the tier on the client of a
self-managed or Dedicated instance to fail fast; see the README.

## Schema caveats

The library follows the OpenAPI description that GitLab generates from its code, and the description has mistakes: a number
typed as a string, a date typed as a date-time, an object with no properties, a status code that the endpoint does not
return. The library corrects the ones it knows, so a few types are looser or stricter than the description says. If a
response does not decode, please [open an issue](https://github.com/piotr-janczukowicz/gitlab-rest-client/issues) with the
operation and the field.

## Not run live

Only a part of the API has been run against a real instance. Administrator, licence-gated and organization endpoints were not.
Verify the behavior of any endpoint you depend on.
