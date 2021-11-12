//package patchesgj.temp
//
//import de.hybris.platform.basecommerce.enums.WeekDay
//import de.hybris.platform.core.Registry
//import de.hybris.platform.servicelayer.model.ModelService
//import de.hybris.platform.servicelayer.search.FlexibleSearchQuery
//import de.hybris.platform.servicelayer.search.FlexibleSearchService
//import de.hybris.platform.servicelayer.search.SearchResult
//import de.hybris.platform.storelocator.model.OpeningDayModel
//import de.hybris.platform.storelocator.model.OpeningScheduleModel
//import de.hybris.platform.storelocator.model.WeekdayOpeningDayModel
//
//import java.text.SimpleDateFormat
//
//namesPos = '''\
//5035
//487
//863
//'''
//
//scheduleWeekdays = '''\
//11:00 - 20:00
//10:00 - 20:00
//10:00 - 22:00
//'''
//
//scheduleWeekends = '''\
//15:00 - 16:00
//16:00 - 17:00
//18:00 - 19:00
//'''
//
//FlexibleSearchService flexibleSearchService = Registry.getApplicationContext().getBean("flexibleSearchService")
//ModelService modelService = Registry.getApplicationContext().getBean("modelService")
//
//List<String> nameList = new ArrayList<>()
//List<List<OpeningScheduleModel>> scheduleList = new ArrayList<>()
//Map<String, List<OpeningScheduleModel>> resultInfo = new HashMap<>();
//
//String query = """
//        SELECT {os.pk}
//        FROM {OpeningSchedule AS os
//        JOIN GjPointOfService AS pos ON {pos:OpeningSchedule}={os.PK}}
//        WHERE {pos.NAME}=?name
//"""
//
//namesPos.eachLine { name ->
//    try {
//        nameList.add(name.trim())
//        println("added in nameList " + name)
//    } catch (Exception e) {
//        e.printStackTrace()
//    }
//}
//
//scheduleWeekdays.eachLine { schedule ->
//    try {
//        String scheduleRow = schedule.replaceAll("\\s", "")
//        println("regex " + scheduleRow)
//        SimpleDateFormat format = new SimpleDateFormat("HH:mm")
//        Date openingTime = format.parse(scheduleRow.substring(0, 5))
//        println("parsed openingTime = " + openingTime)
//        Date closingTime = format.parse(scheduleRow.substring(6, 11))
//        println("parsed closingTime = " + closingTime)
//
//        final WeekdayOpeningDayModel monday = modelService.create(WeekdayOpeningDayModel.class);
//        monday.setClosingTime(closingTime)
//        monday.setDayOfWeek(WeekDay.MONDAY)
//        monday.setOpeningTime(openingTime)
//        println("created monday = " + monday.getPk().toString())
//
//        final WeekdayOpeningDayModel tuesday = modelService.create(WeekdayOpeningDayModel.class);
//        tuesday.setClosingTime(closingTime)
//        tuesday.setDayOfWeek(WeekDay.TUESDAY)
//        tuesday.setOpeningTime(openingTime)
//
//        final WeekdayOpeningDayModel wednesday = modelService.create(WeekdayOpeningDayModel.class);
//        wednesday.setClosingTime(closingTime)
//        wednesday.setDayOfWeek(WeekDay.WEDNESDAY)
//        wednesday.setOpeningTime(openingTime)
//
//        final WeekdayOpeningDayModel thursday = modelService.create(WeekdayOpeningDayModel.class);
//        thursday.setClosingTime(closingTime)
//        thursday.setDayOfWeek(WeekDay.THURSDAY)
//        thursday.setOpeningTime(openingTime)
//
//        final WeekdayOpeningDayModel friday = modelService.create(WeekdayOpeningDayModel.class);
//        friday.setClosingTime(closingTime)
//        friday.setDayOfWeek(WeekDay.FRIDAY)
//        friday.setOpeningTime(openingTime)
//
//        final List<OpeningDayModel> weekDays = new ArrayList<OpeningDayModel>()
//        weekDays.add(monday)
//        weekDays.add(tuesday)
//        weekDays.add(wednesday)
//        weekDays.add(thursday)
//        weekDays.add(friday)
//
//        println("created List<OpeningDayModel> weekDays:")
//        weekDays.forEach({ week -> println(week.getOpeningTime().toString() + " " + week.getClosingTime().toString()) })
//
//        final OpeningScheduleModel openingScheduleModel = modelService.create(OpeningScheduleModel.class)
//        openingScheduleModel.setOpeningDays(weekDays)
//        println("created openingScheduleModel:" + openingScheduleModel.getName() + openingScheduleModel.getCode() + openingScheduleModel.getCode())
//
//
//    } catch (Exception e) {
//        e.printStackTrace()
//    }
//}
//
//if (!nameList.isEmpty() && !scheduleList.isEmpty() && nameList.size() == scheduleList.size()) {
//    for (int i = 0; i < nameList.size(); i++) {
//        resultInfo.put(nameList.get(i), scheduleList.get(i))
//    }
//}
//
//resultInfo.entrySet().each { Map.Entry<String, List<OpeningScheduleModel>> entry ->
//    try {
//        FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(query)
//        flexibleSearchQuery.addQueryParameter("posName", entry.getKey())
//        SearchResult<OpeningScheduleModel> searchResult = flexibleSearchService.search(query)
//        if (searchResult.getResult().size() == 1) {
//            modelService.saveAll(searchResult.getResult().get(0).setOpeningDays(entry.getValue() as Collection<OpeningDayModel>))
//        }
//    } catch (Exception e) {
//        e.printStackTrace()
//    }
//}