/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yury.businessmonitoring.interfaces;

import java.util.List;
import com.yury.businessmonitoring.models.RAMModel;

/**
 *
 * @author Юрий
 */
public interface ILoader {
    public List<RAMModel> load();
}
