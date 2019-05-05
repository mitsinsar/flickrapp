package com.kangarootech.flickr.enums

////////////////////////////
//    Mithat Sinan Sarı   // 
//                        //
// m.sinan.sari@gmail.com //
//------------------------//
//        4.05.2019     //
//------------------------//
//           ʕ•ᴥ•ʔ         //
////////////////////////////


enum class ApiEnum {
    API_KEY {
        override fun toString(): String {
            return "95f869e39704ca91477799b706a64be4"
        }
    },

    API_KEY_SECRET {
        override fun toString(): String {
            return "23bf605daa04a950"
        }
    },

    API_BASE_URL {
        override fun toString(): String {
            return "https://api.flickr.com/services/rest/"
        }
    }
}