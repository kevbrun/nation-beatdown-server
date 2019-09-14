package ch.nation.core.model.dtoWrapper;

import ch.nation.core.model.dto.AbstractDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.PagedResources;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimpleResourceDto implements Serializable {
    @JsonProperty("page")
    private SimpleResourcePageDto pageInfo;

    @JsonProperty("elements")
    private List<AbstractDto>  elements;


    public SimpleResourceDto(long size, long totalElements, long totalPages, long number, List<AbstractDto> elements) {
        this.pageInfo = new SimpleResourcePageDto(size,totalElements,totalPages,number);
        this.elements = elements;
    }

    public SimpleResourceDto(PagedResources resource){
        this(resource.getMetadata().getSize()
                ,resource.getMetadata().getTotalElements()
                ,resource.getMetadata().getTotalPages()
                ,resource.getMetadata().getNumber(),
                new ArrayList<>(resource.getContent()));


    }

    public SimpleResourceDto() {
    }



    public SimpleResourcePageDto getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(SimpleResourcePageDto pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<AbstractDto> getElements() {
        return elements;
    }

    public void setElements(List<AbstractDto> elements) {
        this.elements = elements;
    }
}
