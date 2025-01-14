package vuluu.notificationservice.controller;

import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vuluu.notificationservice.dto.response.ApiResponse;
import vuluu.notificationservice.dto.response.UserNotificationResponseDTO;
import vuluu.notificationservice.entity.Notification;
import vuluu.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class NotificationController {

  private final NotificationService notificationService;

  // Lấy tất cả thông báo của một user
  @GetMapping("/count-user-notifications")
  public ApiResponse<Integer> countNotificationNotRead() {
    return ApiResponse.<Integer>builder()
        .result(notificationService.countNotificationNotRead()).build();
  }

  @GetMapping("/user-notifications")
  public ApiResponse<List<UserNotificationResponseDTO>> getNotificationsForUser() {
    return ApiResponse.<List<UserNotificationResponseDTO>>builder()
        .result(notificationService.getNotificationsForUser()).build();
  }

  // Đánh dấu thông báo là đã đọc
  @PatchMapping("/{notificationId}/read")
  public ResponseEntity<Void> markAsRead(@PathVariable Long notificationId) {
    notificationService.markAsRead(notificationId);
    return ResponseEntity.noContent().build();
  }

  // Gửi thông báo toàn cục
  @PostMapping("/global")
  public ResponseEntity<Void> sendGlobalNotification(@RequestBody Notification notification) {
    notificationService.sendGlobalNotification(notification);
    return ResponseEntity.ok().build();
  }
}
