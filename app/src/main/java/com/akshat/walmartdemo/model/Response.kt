package com.akshat.walmartdemo.model

import com.google.gson.annotations.SerializedName

data class Response(

	@SerializedName("Response")
	val response: List<ResponseItem>? = null
)

data class Language(

	@SerializedName("code")
	val code: String? = null,

	@SerializedName("name")
	val name: String? = null
)

data class ResponseItem(

	@SerializedName("capital")
	val capital: String? = null,

	@SerializedName("code")
	val code: String? = null,

	@SerializedName("flag")
	val flag: String? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("currency")
	val currency: Currency? = null,

	@SerializedName("language")
	val language: Language? = null,

	@SerializedName("region")
	val region: String? = null
)

data class Currency(

	@SerializedName("symbol")
	val symbol: String? = null,

	@SerializedName("code")
	val code: String? = null,

	@SerializedName("name")
	val name: String? = null
)
