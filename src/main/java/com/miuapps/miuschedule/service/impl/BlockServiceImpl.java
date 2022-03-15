package com.miuapps.miuschedule.service.impl;

import com.miuapps.miuschedule.model.Block;
import com.miuapps.miuschedule.repository.BlockRepository;
import com.miuapps.miuschedule.service.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * BlockServiceImpl class implements IBlockService and saves the block object to
 * mongodb using blockRepository save method.
 */
@Service
public class BlockServiceImpl implements IBlockService {
    private final BlockRepository blockRepository;

    /**
     * Instantiates a new Block service.
     *
     * @param blockRepository the block repository
     */
    @Autowired
    public BlockServiceImpl(BlockRepository blockRepository){
        this.blockRepository = blockRepository;
    }

    @Override
    public void saveBlock(Block block) {
        blockRepository.save(block);
    }

    @Override
    public List<Block> getAllBlock(){
        return blockRepository.findAll();
    }
}
