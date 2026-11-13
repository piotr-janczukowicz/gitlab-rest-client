# Immutability

Previous: [Pagination](pagination.md) · Next: [Good to know](good-to-know.md) · [Guide index](README.md)

- **Responses are immutable records.** A model never changes after it is decoded. Collections inside it are unmodifiable.
- **Absent fields are `null`.** GitLab leaves a property out when it has no value, and the record component is `null`. A
  component that can be absent is annotated `@Nullable`.
- **Your inputs are copied.** A `...Payload` or `...Filter` record copies the lists and maps you give it, so changing your
  list afterwards does not change a request that is built.
- **Builders.** Every request record has a `...Builder`. To change one field of an existing record, start the builder from it
  and set the field.
- **Thread safety.** Clients, resources and models are thread-safe. A `GitLabPage` is not.
