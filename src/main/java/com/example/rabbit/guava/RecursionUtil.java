package com.example.rabbit.guava;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RecursionUtil<T extends Recursion> {
    public List<T> buildTree(List<T> roots, List<T> all) {
        setChildren(all, roots);
        return roots;

    }


    private <T extends Recursion>void setChildren(List<T> all, List<T> parents) {
        parents.forEach(parent -> {
            List<T> childList =
                    all.stream().filter(child -> child.getParentId().equals(parent.getId())).collect(Collectors.toList());
            parent.setChildren(childList);
            if (CollectionUtils.isNotEmpty(childList)) {
                setChildren(all, childList);
            }
        });
    }
}
