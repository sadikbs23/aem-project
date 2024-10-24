package com.adobe.aem.guides.wknd.core.models;

import lombok.Getter;
import lombok.Setter;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

@Setter
@Getter
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Contact {
    @Inject
    private String contactName;

    @Inject
    private String contactEmail;

    @Inject
    private boolean isActive;

    @Inject
    private String occupation;

    @Inject
    private String comments;

    @Inject
    private String country;

    @Inject
    private List<String> hobbies;

    @Inject
    private String selectedPath;

    @PostConstruct
    protected void init() {
        if (selectedPath != null && !selectedPath.isEmpty()) {

            if (!selectedPath.matches(".*\\.[a-zA-Z0-9]+$")) {

                selectedPath = selectedPath.concat(".html");
            }
        }
    }

}
