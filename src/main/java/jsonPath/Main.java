package jsonPath;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        JsonElement json = new Gson().fromJson("{\n" +
                "  \"success\": true,\n" +
                "  \"body\": {\n" +
                "    \"roadMap\": {\n" +
                "      \"activityId\": \"06a5a7b4-f798-41fb-adb3-9b349d4b62a2\",\n" +
                "      \"status\": \"STARTED\",\n" +
                "      \"sla\": {\n" +
                "        \"status\": \"COMPLETED\",\n" +
                "        \"isExpiration\": false,\n" +
                "        \"deadline\": \"2024-03-01T20:53:00.512Z\",\n" +
                "        \"startDate\": \"2023-12-04T11:59:42.804Z\"\n" +
                "      },\n" +
                "      \"stages\": [\n" +
                "        {\n" +
                "          \"id\": \"FZHN:DealStructuring\",\n" +
                "          \"name\": \"Структурирование\",\n" +
                "          \"number\": 20,\n" +
                "          \"status\": \"POSITIVE_ENDING\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"COMPLETED\",\n" +
                "            \"numberDays\": 0,\n" +
                "            \"isExpiration\": false,\n" +
                "            \"deadline\": \"2023-12-04T12:48:01.410Z\",\n" +
                "            \"startDate\": \"2023-12-04T12:38:01.410Z\",\n" +
                "            \"endDate\": \"2023-12-04T12:38:07.680Z\"\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"NO_SCENARIO\",\n" +
                "              \"name\": \"NO_SCENARIO\",\n" +
                "              \"status\": \"SKIPPED\",\n" +
                "              \"mode\": \"OPTIONAL\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"creating_sublimit_by_product\",\n" +
                "              \"name\": \"Создание лимита\",\n" +
                "              \"status\": \"POSITIVE_ENDING\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"event\": {\n" +
                "                \"eventId\": \"21Y-MLS\",\n" +
                "                \"systemId\": \"LBF\",\n" +
                "                \"link\": \"not implemented\",\n" +
                "                \"type\": \"pprb_deal_id\",\n" +
                "                \"addIds\": [\n" +
                "                  {\n" +
                "                    \"eventId\": \"SL_000000009267919\",\n" +
                "                    \"systemId\": \"OLYMPLIMIT\",\n" +
                "                    \"type\": \"sublimit\"\n" +
                "                  }\n" +
                "                ]\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"DealCreating\",\n" +
                "              \"name\": \"Создание сделки\",\n" +
                "              \"status\": \"POSITIVE_ENDING\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"event\": {\n" +
                "                \"eventId\": \"21Y-MLS\",\n" +
                "                \"systemId\": \"LBF\",\n" +
                "                \"link\": \"PRIVATE\",\n" +
                "                \"type\": \"SCENARIO_RESULT\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"BBB:PPRB.CLFADAPTER\",\n" +
                "              \"name\": \"BBB:PPRB.CLFADAPTER\",\n" +
                "              \"status\": \"POSITIVE_ENDING\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"COMPLETED\",\n" +
                "                \"numberDays\": 0,\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2023-12-04T12:43:01.308Z\",\n" +
                "                \"startDate\": \"2023-12-04T12:38:01.308Z\",\n" +
                "                \"endDate\": \"2023-12-04T12:38:04.781Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:Create_KOD\",\n" +
                "          \"name\": \"Подготовка КОД\",\n" +
                "          \"number\": 90,\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false,\n" +
                "            \"deadline\": \"2024-03-01T20:53:00.512Z\"\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"BBB:TM\",\n" +
                "              \"name\": \"BBB:TM\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2024-03-01T20:53:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:Document_Collecting\",\n" +
                "          \"name\": \"Сбор и анализ документов\",\n" +
                "          \"number\": 60,\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false,\n" +
                "            \"deadline\": \"2023-12-05T20:53:00.512Z\"\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"FZHNDocumentCollecting\",\n" +
                "              \"name\": \"Сбор документов\",\n" +
                "              \"status\": \"ACCEPTED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"BBB:ZALOGI\",\n" +
                "              \"name\": \"Сбор документов: залоги\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2023-12-05T20:53:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"LKSEDocumentRequest\",\n" +
                "              \"name\": \"LKSEDocumentRequest\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2023-12-05T20:53:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:DealDecisionMaking05\",\n" +
                "          \"name\": \"FZHN:DealDecisionMaking05\",\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"DealDecisionMaking\",\n" +
                "              \"name\": \"DealDecisionMaking\",\n" +
                "              \"status\": \"ACCEPTED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"NO_SCENARIO\",\n" +
                "              \"name\": \"NO_SCENARIO\",\n" +
                "              \"status\": \"SKIPPED\",\n" +
                "              \"mode\": \"OPTIONAL\",\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:LKSE_Express\",\n" +
                "          \"name\": \"Подготовка заключений\",\n" +
                "          \"number\": 30,\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false,\n" +
                "            \"deadline\": \"2023-12-05T12:43:00.512Z\"\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"DigitalExpertCalculation\",\n" +
                "              \"name\": \"DigitalExpertCalculation\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2023-12-05T12:43:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"CashFlowModelCalculate\",\n" +
                "              \"name\": \"CashFlowModelCalculate\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2023-12-05T12:43:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:DealDecisionMaking03\",\n" +
                "          \"name\": \"FZHN:DealDecisionMaking03\",\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"DealDecisionMaking\",\n" +
                "              \"name\": \"DealDecisionMaking\",\n" +
                "              \"status\": \"ACCEPTED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"NO_SCENARIO\",\n" +
                "              \"name\": \"NO_SCENARIO\",\n" +
                "              \"status\": \"SKIPPED\",\n" +
                "              \"mode\": \"OPTIONAL\",\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:DealDecisionMaking04\",\n" +
                "          \"name\": \"FZHN:DealDecisionMaking04\",\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"NO_SCENARIO\",\n" +
                "              \"name\": \"NO_SCENARIO\",\n" +
                "              \"status\": \"SKIPPED\",\n" +
                "              \"mode\": \"OPTIONAL\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"DealDecisionMaking\",\n" +
                "              \"name\": \"DealDecisionMaking\",\n" +
                "              \"status\": \"ACCEPTED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:TS_Sign\",\n" +
                "          \"name\": \"Подписание TS\",\n" +
                "          \"number\": 70,\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false,\n" +
                "            \"deadline\": \"2023-12-25T20:53:00.512Z\"\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"ConstructionCreditRequestTermsheetSigning\",\n" +
                "              \"name\": \"ConstructionCreditRequestTermsheetSigning\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2023-12-25T20:53:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"BBB:MD\",\n" +
                "              \"name\": \"BBB:MD\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2023-12-25T20:53:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:DealDecisionMaking01\",\n" +
                "          \"name\": \"FZHN:DealDecisionMaking01\",\n" +
                "          \"status\": \"STARTED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"COMPLETED\",\n" +
                "            \"isExpiration\": false,\n" +
                "            \"deadline\": \"2023-12-04T12:43:07.875Z\",\n" +
                "            \"startDate\": \"2023-12-04T12:38:07.875Z\"\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"NO_SCENARIO\",\n" +
                "              \"name\": \"NO_SCENARIO\",\n" +
                "              \"status\": \"SKIPPED\",\n" +
                "              \"mode\": \"OPTIONAL\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"DealDecisionMaking\",\n" +
                "              \"name\": \"DealDecisionMaking\",\n" +
                "              \"status\": \"STARTED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:DealDecisionMaking06\",\n" +
                "          \"name\": \"FZHN:DealDecisionMaking06\",\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"DealDecisionMaking\",\n" +
                "              \"name\": \"DealDecisionMaking\",\n" +
                "              \"status\": \"ACCEPTED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"NO_SCENARIO\",\n" +
                "              \"name\": \"NO_SCENARIO\",\n" +
                "              \"status\": \"SKIPPED\",\n" +
                "              \"mode\": \"OPTIONAL\",\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:Dept_Approval\",\n" +
                "          \"name\": \"Детальный анализ\",\n" +
                "          \"number\": 80,\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false,\n" +
                "            \"deadline\": \"2024-01-01T20:53:00.512Z\"\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"FZHNDeptApproval\",\n" +
                "              \"name\": \"Детальный анализ\",\n" +
                "              \"status\": \"ACCEPTED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"BBB:MD\",\n" +
                "              \"name\": \"BBB:MD\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"OPTIONAL\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"BBB:ZALOGI\",\n" +
                "              \"name\": \"Сбор документов: залоги\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2024-01-01T20:53:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"DetailedAnalysis\",\n" +
                "              \"name\": \"DetailedAnalysis\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2024-01-01T20:53:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:ClientRequestCreating\",\n" +
                "          \"name\": \"FZHN:ClientRequestCreating\",\n" +
                "          \"status\": \"NEUTRAL_ENDING\",\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"ConstructionCreditRequestCreating\",\n" +
                "              \"name\": \"ConstructionCreditRequestCreating\",\n" +
                "              \"status\": \"NEUTRAL_ENDING\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"event\": {\n" +
                "                \"eventId\": \"6988708d-9e11-4c1b-b473-ea335705a085\",\n" +
                "                \"systemId\": \"LKKSBERBUSINESS\",\n" +
                "                \"link\": \"/v2/credits/requests/constructions/6988708d-9e11-4c1b-b473-ea335705a085/project-info\",\n" +
                "                \"type\": \"SCENARIO_RESULT\",\n" +
                "                \"addIds\": [\n" +
                "                  {\n" +
                "                    \"eventId\": \"1450762741983033005\",\n" +
                "                    \"systemId\": \"EPK\",\n" +
                "                    \"type\": \"ucp_client_id\"\n" +
                "                  },\n" +
                "                  {\n" +
                "                    \"eventId\": \"ONLINE_CONSTRUCT\",\n" +
                "                    \"systemId\": \"SBERBUSINESS\",\n" +
                "                    \"type\": \"credit_process_line\"\n" +
                "                  }\n" +
                "                ]\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:Model_Calculate\",\n" +
                "          \"name\": \"Формирование CF-модели и TS\",\n" +
                "          \"number\": 40,\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false,\n" +
                "            \"deadline\": \"2023-12-05T16:43:00.512Z\"\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"CashFlowModelCalculate\",\n" +
                "              \"name\": \"CashFlowModelCalculate\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2023-12-05T16:43:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:DealDecisionMaking07\",\n" +
                "          \"name\": \"FZHN:DealDecisionMaking07\",\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"NO_SCENARIO\",\n" +
                "              \"name\": \"NO_SCENARIO\",\n" +
                "              \"status\": \"SKIPPED\",\n" +
                "              \"mode\": \"OPTIONAL\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"DealDecisionMaking\",\n" +
                "              \"name\": \"DealDecisionMaking\",\n" +
                "              \"status\": \"ACCEPTED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:DealDecisionMaking02\",\n" +
                "          \"name\": \"FZHN:DealDecisionMaking02\",\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"DealDecisionMaking\",\n" +
                "              \"name\": \"DealDecisionMaking\",\n" +
                "              \"status\": \"ACCEPTED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"issues\": []\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"NO_SCENARIO\",\n" +
                "              \"name\": \"NO_SCENARIO\",\n" +
                "              \"status\": \"SKIPPED\",\n" +
                "              \"mode\": \"OPTIONAL\",\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"FZHN:Risk_Approval\",\n" +
                "          \"name\": \"Принятие решения\",\n" +
                "          \"number\": 50,\n" +
                "          \"status\": \"INITIATED\",\n" +
                "          \"mode\": \"REQUIRED\",\n" +
                "          \"sla\": {\n" +
                "            \"status\": \"INITIALIZED\",\n" +
                "            \"isExpiration\": false,\n" +
                "            \"deadline\": \"2023-12-05T16:53:00.512Z\"\n" +
                "          },\n" +
                "          \"services\": [\n" +
                "            {\n" +
                "              \"id\": \"BP_UPDATED\",\n" +
                "              \"name\": \"BP_UPDATED\",\n" +
                "              \"status\": \"INITIATED\",\n" +
                "              \"mode\": \"REQUIRED\",\n" +
                "              \"sla\": {\n" +
                "                \"status\": \"INITIALIZED\",\n" +
                "                \"isExpiration\": false,\n" +
                "                \"deadline\": \"2023-12-05T16:53:00.512Z\"\n" +
                "              },\n" +
                "              \"issues\": []\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}", JsonElement.class);
        System.out.println(JsonPath.getValue(json, "*.*.stages[~].mode.distinct()"));
        System.out.println(JsonPath.getValue(json, "*.*.*[(id)][~].mode.distinct()"));
        System.out.println(JsonPath.getValue(json, "*.*.*[(id)][~].sla.name()"));
        System.out.println(JsonPath.getValue(json, "*.*.*[(id)][~].sla.distinct()"));
        System.out.println(JsonPath.getValue(json, "*.*.*[(id)][~].sla.status.distinct()"));

        //regenTests(json);
    }

    private static void regenTests(JsonElement json) {
        Map<String, List<String>> tests = new HashMap<>();

        List<String> pathTest = new ArrayList<>();
        pathTest.add("library");
        pathTest.add("library.location");
        pathTest.add("library.books");
        pathTest.add("library.books[1]");
        pathTest.add("library.books[~].title");
        pathTest.add("library.books.title");
        tests.put("PathTest", pathTest);

        List<String> conditionTest = new ArrayList<>();
        conditionTest.add("library.books[(publication_year < 1868)].details.available_copies");
        conditionTest.add("library.books[(publication_year == 1949 || publication_year == 1866)][~].title");
        conditionTest.add("library.books[(details.pages < 500)][~].details.pages");
        conditionTest.add("library.books[(publisher == \"The Russian Messenger\")].title");
        conditionTest.add("library.books[(publisher == \"The Russian Messenger\")][0].title");
        conditionTest.add("library.books[(publisher == \"The Russian Messenger\")][1].title");
        conditionTest.add("library.books[({author == \"Leo Tolstoy\" || author == \"Harper Lee\"} && details.pages < 500)][~].details.pages");
        conditionTest.add("library.books[(reviews[(user == \"Mary\")])]");
        conditionTest.add("library.books[(reviews)]");
        conditionTest.add("library.books[(author == \"George Orwell\" && title == \"1984\" || title == \"War and Peace\" && publication_year == 1869)][~].title");
        conditionTest.add("library.books[(author == \"George Orwell\" && {title == \"1984\" || title == \"War and Peace\"} && publication_year == 1869)][~].title");
        conditionTest.add("library.books[(reviews[nonMatch(rating == 6)])][~].title");
        conditionTest.add("library.books[(reviews[nonMatch(rating == 5)])][~].title");
        conditionTest.add("library.books[(reviews[nonMatch(rating == 4)])][~].title");
        conditionTest.add("library.books[(reviews[allMatch(rating == 4)])][~].title");
        conditionTest.add("library.books[(reviews[allMatch(rating == 5)])][~].title");
        conditionTest.add("library.books[(reviews[(awards[allMatch(prize == 1500)])])]");
        tests.put("ConditionTest", conditionTest);

        List<String> functionTest = new ArrayList<>();
        functionTest.add("library.books[~].details.pages.sort()");
        functionTest.add("library.books[~].details.pages.size()");
        functionTest.add("library.books[~].title.sort()");
        functionTest.add("library.size()");
        functionTest.add("library.asdad.size()");
        functionTest.add("library.books[(publisher == contains(\"Russian\"))]");
        functionTest.add("library.books[(title == reg(\"[1-9]*\"))].title");
        tests.put("FunctionTest", functionTest);

        List<String> axisTest = new ArrayList<>();
        axisTest.add("library.books[(details.available_copies == ../floor_count)].details.available_copies");
        tests.put("AxisTest", axisTest);

        List<String> hardcoreTest = new ArrayList<>();
        hardcoreTest.add("library.books[(details.available_copies == ../floor_count)].reviews[(rating > 4)].user");
        tests.put("HardcoreTest", hardcoreTest);

        for (Map.Entry<String, List<String>> list : tests.entrySet()) {
            System.out.printf("%s\n", list.getKey());
            for (String str : list.getValue()) {
                System.out.printf("softAssert.assertEquals(JsonPath.getValue(json, \"%s\"), \"%s\", \"%s\");\n", str.replaceAll("\\\"", "\\\\\""), JsonPath.getValue(json, str).replaceAll("\\\"", "\\\\\""), str.replaceAll("\\\"", "\\\\\""));
            }
            System.out.printf("\n\n\n");
        }
    }
}