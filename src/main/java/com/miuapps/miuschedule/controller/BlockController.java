package com.miuapps.miuschedule.controller;

import com.miuapps.miuschedule.model.Block;
import com.miuapps.miuschedule.service.impl.BlockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Block controller.
 */
@RestController
@RequestMapping("block")
public class BlockController {
    private BlockServiceImpl blockServiceImpl;

    /**
     * Instantiates a new Block controller.
     *
     * @param blockService the block service
     */
    @Autowired
    public BlockController(BlockServiceImpl blockService){
        this.blockServiceImpl = blockService;
    }

    /**
     * Save block.
     *
     * @param block the block
     */
    @PostMapping(value = "")
    public void saveBlock(@RequestBody Block block){
        blockServiceImpl.saveBlock(block);
    }

    /**
     * Gets all block.
     *
     * @return the all block
     */
    @GetMapping(value="")
    @ResponseBody
    public List<Block> getAllBlock() {
        return blockServiceImpl.getAllBlock();
    }

    /**
     * Gets block by id.
     *
     * @param blockId the block id
     * @return the block by id
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Block getBlockById(@PathVariable("id") String blockId) {
        return blockServiceImpl.getBlockById(blockId);
    }


}
