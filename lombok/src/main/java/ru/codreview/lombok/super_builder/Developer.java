package lombok.super_builder;

import lombok.experimental.SuperBuilder;

import java.util.Set;
@SuperBuilder
public class Developer extends Man {
    Set<String> skills;
}
