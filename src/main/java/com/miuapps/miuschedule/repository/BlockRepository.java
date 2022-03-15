package com.miuapps.miuschedule.repository;


import com.miuapps.miuschedule.model.Block;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The interface Block repository.
 */
public interface BlockRepository extends MongoRepository<Block, String> {
    /**
     * Find block by id block.
     *
     * @param blockId the block id
     * @return the block
     */
    Block findBlockById(String blockId);

    /**
     * Find block by name block.
     *
     * @param blockName the block name
     * @return the block
     */
    Block findBlockByName(String blockName);

}
