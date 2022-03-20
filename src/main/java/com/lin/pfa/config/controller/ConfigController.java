package com.lin.pfa.config.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lin.pfa.api.common.Action;
import com.lin.pfa.api.common.AssetCategory;
import com.lin.pfa.api.common.ConfigServiceApi;
import com.lin.pfa.api.common.Currency;
import com.lin.pfa.api.common.Exchange;
import com.lin.pfa.config.entity.ActionEntity;
import com.lin.pfa.config.entity.ActionRepository;
import com.lin.pfa.config.entity.AssetCategoryEntity;
import com.lin.pfa.config.entity.AssetCategoryRepository;
import com.lin.pfa.config.entity.CurrencyEntity;
import com.lin.pfa.config.entity.CurrencyRepository;
import com.lin.pfa.config.entity.ExchangeEntity;
import com.lin.pfa.config.entity.ExchangeRepository;

@RestController
@RequestMapping("/config")
public class ConfigController implements ConfigServiceApi {
	@Autowired
	private CurrencyRepository currencyRespository;
	@Autowired
	private AssetCategoryRepository categoryRespository;
	@Autowired
	private ExchangeRepository exchangeRespository;
	@Autowired
	private ActionRepository actionRespository;
	
	private ModelMapper mapper = new ModelMapper(); 
	
	@GetMapping("currencies")
	public ResponseEntity<List<Currency>> getCurrencies() {
		List<CurrencyEntity> l = currencyRespository.findAll();
		
		Type listType = new TypeToken<List<Currency>>(){}.getType();
		List<Currency> currencies = mapper.map(l, listType);
		
		
		return ResponseEntity.ok(currencies);
	}
	
	@GetMapping("categories")
	public ResponseEntity<List<AssetCategory>> getCategoris() {
		List<AssetCategoryEntity> l = categoryRespository.findAll();

		Type listType = new TypeToken<List<AssetCategory>>(){}.getType();
		List<AssetCategory> categories = mapper.map(l, listType);
		
		return ResponseEntity.ok(categories);
	}
	
	@GetMapping("exchanges")
	public ResponseEntity<List<Exchange>> getExchanges() {
		List<ExchangeEntity> l = exchangeRespository.findAll();

		Type listType = new TypeToken<List<Exchange>>(){}.getType();
		List<Exchange> exchanges = mapper.map(l, listType);
		
		return ResponseEntity.ok(exchanges);
	}
	
	@GetMapping("actions")
	public ResponseEntity<List<Action>> getTransactionTypes() {
		List<ActionEntity> l = actionRespository.findAll();

		Type listType = new TypeToken<List<Action>>(){}.getType();
		List<Action> actions = mapper.map(l, listType);
		
		return ResponseEntity.ok(actions);
	}
}
