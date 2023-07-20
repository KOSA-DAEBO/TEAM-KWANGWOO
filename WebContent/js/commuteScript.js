$(function () {

    const googleApikey = config.googleApikey;
    // calendar element 취득
    var calendarEl = $('#calendar')[0];
    // full-calendar 생성하기
    var calendar = new FullCalendar.Calendar(calendarEl, {
            googleCalendarApiKey: googleApikey,
            eventSources: [
                {
                    googleCalendarId: 'ko.south_korea#holiday@group.v.calendar.google.com'
                    , color: 'white'   // an option!
                    , textColor: 'red' // an option!
                }
            ],
            height: '700px', // calendar 높이 설정
            expandRows: true, // 화면에 맞게 높이 재설정
            slotMinTime: '00:00', // Day 캘린더에서 시작 시간
            slotMaxTime: '23:59', // Day 캘린더에서 종료 시간

            // 해더에 표시할 툴바
            headerToolbar: {
                center: 'title',
                left: '',
                right: 'prev,next today',
            },
            initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
            selectable: true, // 달력 일자 드래그 설정가능
            nowIndicator: true, // 현재 시간 마크
            dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
            locale: 'ko', // 한국어 설정
            displayEventTime: false, // 이벤트 시간 보이기

            // 이벤트
            events: jsonArray

        }
    );
    // 캘린더 랜더링
    calendar.render();
});
